package com.example.Api.user.Controller;

import com.example.Api.user.Dto.UserDto;
import com.example.Api.user.Dto.UserListDto;
import com.example.Api.user.Dto.UserSearchDto;
import com.example.Api.user.Entity.User;
import com.example.Api.user.Service.UserService;
import com.example.global.common.dto.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bi/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 사용자 조회 API
    @GetMapping("/table")
    public List<UserListDto> getAllUsers() {
        return userService.getAllUsers();
    }

    // 사용자 등록 API
    @PostMapping("/regiUser")
    public SuccessResponse<User> registerUser(@RequestBody UserDto userDtO) {
        return new SuccessResponse<>(userService.registerUser(userDtO));
    }


    // 사용자 수정 APi
    @PostMapping("/update/{id}")
    public SuccessResponse<?> userUpdate(@PathVariable Integer id) {
        userService.updateUser(id);
        return new SuccessResponse<>(HttpStatus.OK.value());
    }

    // 사용자 제거 APi
    @PostMapping("/delete/{id}")
    public SuccessResponse<?> userDelete(@PathVariable Integer id) {
        userService.deleteUser(id);
        return new SuccessResponse<>(HttpStatus.OK.value());
    }

    // 사용자 검색 API
    // 단어 검색시에는 kind와 word에만 값이 들어있고, 날짜 검색시에는 word에는 null값이 들어있다.
    @PostMapping("/search")
    public SuccessResponse<Map<String, Object>> searchUsers(@RequestBody UserSearchDto userSearchDto) {
        return new SuccessResponse<>(userService.searchUsers(userSearchDto));
    }

}