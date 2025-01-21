package com.example.Api.user.Service;

import com.example.Api.user.Dto.UserDto;
import com.example.Api.user.Dto.UserGroupBySearchDto;
import com.example.Api.user.Dto.UserListDto;
import com.example.Api.user.Dto.UserSearchDto;
import com.example.Api.user.Entity.User;
import com.example.Api.user.Repository.UserRepository;
import com.example.Api.user.Repository.UserRepositoryCustom;
import com.example.global.common.exception.CustomException;
import com.example.global.common.exception.ErrorCode;
import com.querydsl.core.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRepositoryCustom userRepositoryCustom;

    // 모든 사용자 조회
    // -> USE YN 속성이 Y인 데이터만 보이도록 수정
    public List<UserListDto> getAllUsers() {
        List<User> users = userRepositoryCustom.getUserList();
        // 엔티티를 DTO로 변환
        return users.stream()
                .map(user -> new UserListDto(
                        user.getId(),
                        user.getUserNm(),
                        user.getUserId(),
                        user.getPw(),
                        user.getRegiDt(),
                        user.getRegiUser(),
                        user.getUpdaUser(),
                        user.getUpdaDt(),
                        user.getUseYn()
                ))
                .collect(Collectors.toList());

    }

    // 사용자 등록
    @Transactional
    public User registerUser(UserDto userDTO) {
        // 우선 userid와 일치하는 id가 있는지 확인
        User findUser = userRepository.findByUserId(userDTO.getUserId());
        if(findUser != null) {
            throw new CustomException(ErrorCode.USER_ALREADY_EXIST_ERROR);
        }

        // DTO를 엔티티로 변환
        User user = new User(
                userDTO.getUserNm(),
                userDTO.getUserId(),
                userDTO.getPw(),
                LocalDateTime.now(),  // 현재 시간으로 등록일 설정
                userDTO.getRegiUser(),
                "Y"
        );
        // DB에 저장
        return userRepository.save(user);
    }

    // 사용자 업데이트
    @Transactional
    public void updateUser(Integer id) {
        User user = userRepository.findById(Long.valueOf(id)).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND_ERROR1));
        if(user.getUseYn().equals("N")){
            throw new CustomException(ErrorCode.USER_NOT_FOUND_ERROR1);
        }
        user.update();
    }

    // 사용자 제거
    @Transactional
    public void deleteUser(Integer id) {
        User user = userRepository.findById(Long.valueOf(id)).orElseThrow(() ->  new CustomException(ErrorCode.USER_NOT_FOUND_ERROR2));
        if(user.getUseYn().equals("N")){
            throw new CustomException(ErrorCode.USER_NOT_FOUND_ERROR2);
        }
        user.delete();
    }

    // 사용자 검색 기능
    public Map<String, Object> searchUsers(UserSearchDto userSearchDto) {
        // 1. 우선 조건에 맞는 데이터를 먼저 검색
        System.out.println(userSearchDto.getRegiDtFrom()+" !! "+ userSearchDto.getRegiDtTo());
        List<User> userList = userRepositoryCustom.searchUsers(userSearchDto.getUserNm(), userSearchDto.getUserId(),userSearchDto.getRegiUser(),userSearchDto.getUpdaUser(),
                userSearchDto.getRegiDtFrom(),userSearchDto.getRegiDtTo(),userSearchDto.getUpdaDtFrom(),userSearchDto.getUpdaDtTo());

        // UserListDto로 변환
        List<UserListDto> searchList =  userList.stream()
                .map(user -> new UserListDto(
                        user.getId(),
                        user.getUserNm(),
                        user.getUserId(),
                        user.getPw(),
                        user.getRegiDt(),
                        user.getRegiUser(),
                        user.getUpdaUser(),
                        user.getUpdaDt(),
                        user.getUseYn()
                ))
                .collect(Collectors.toList());

        // 2. 등록일에 따른 계정 수 데이터 결과 검색
        List<Tuple> groupList = userRepositoryCustom.groupBySearch(userSearchDto.getUserNm(), userSearchDto.getUserId(),userSearchDto.getRegiUser(),userSearchDto.getUpdaUser(),
                userSearchDto.getRegiDtFrom(),userSearchDto.getRegiDtTo(),userSearchDto.getUpdaDtFrom(),userSearchDto.getUpdaDtTo());
        // UserGroupBySearchDto로 변환
        List<UserGroupBySearchDto> groupByList = groupList.stream()
                .map(result -> new UserGroupBySearchDto(
                        result.get(0,String.class),
                        result.get(1, Long.class)
                ))
                .collect(Collectors.toList());

        // 결과를 Map으로 묶어서 반환
        Map<String, Object> result = new HashMap<>();
        result.put("searchList", searchList);
        result.put("groupByList", groupByList);
        return result;
    }




}
