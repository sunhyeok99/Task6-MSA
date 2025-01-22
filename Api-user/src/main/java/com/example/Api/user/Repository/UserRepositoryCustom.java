package com.example.Api.user.Repository;

import com.example.Api.user.Entity.User;
import com.querydsl.core.Tuple;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface UserRepositoryCustom {

    // useYn = "Y"인 전체 데이터 조회
    List<User> getUserList();

    // 사용자 검색 조건에 따른 데이터 조회
    List<User> searchUsers(@Param("userNm") String userNm,
                           @Param("userId") String userId,
                           @Param("regiUser") String regiUser,
                           @Param("updaUser") String updaUser,
                           @Param("regiDtFrom") LocalDateTime regiDtFrom, @Param("regiDtTo") LocalDateTime regiDtTo,
                           @Param("updaDtFrom") LocalDateTime updaDtFrom, @Param("updaDtTo") LocalDateTime updaDtTo);

    // 사용자 검색 조건에 등록일과 계정 수로 그룹화한 데이터 결과
//    @Query("SELECT CONVERT(CHAR(10), u.regiDt, 23), COUNT(u.userNm) FROM User u WHERE u.useYn = 'Y' AND " +
//            "(:userNm IS NULL OR u.userNm LIKE %:userNm%) AND (:userId IS NULL OR u.userId LIKE %:userId%) AND " +
//            "(:regiUser IS NULL OR u.regiUser LIKE %:regiUser%) AND (:updaUser IS NULL OR u.updaUser LIKE %:updaUser%) AND " +
//            "(:regiDtFrom IS NULL OR u.regiDt >= :regiDtFrom) AND (:regiDtTo IS NULL OR u.regiDt <= :regiDtTo) AND " +
//            "(:updaDtFrom IS NULL OR u.updaDt >= :updaDtFrom) AND (:updaDtTo IS NULL OR u.updaDt <= :updaDtTo) " +
//            "GROUP BY CONVERT(CHAR(10), u.regiDt, 23)")
    List<Tuple> groupBySearch(@Param("userNm") String userNm,
                              @Param("userId") String userId,
                              @Param("regiUser") String regiUser,
                              @Param("updaUser") String updaUser,
                              @Param("regiDtFrom") LocalDateTime regiDtFrom, @Param("regiDtTo") LocalDateTime regiDtTo,
                              @Param("updaDtFrom") LocalDateTime updaDtFrom, @Param("updaDtTo") LocalDateTime updaDtTo);

}
