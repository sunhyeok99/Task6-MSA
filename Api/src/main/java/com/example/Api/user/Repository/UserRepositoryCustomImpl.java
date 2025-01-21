package com.example.Api.user.Repository;

import com.example.Api.user.Entity.QUser;
import com.example.Api.user.Entity.User;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {


    private final JPAQueryFactory jpaQueryFactory;

    public UserRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    // useYn = "Y"인 전체 데이터 조회
    @Override
    public List<User> getUserList() {
        QUser user = QUser.user;

        return jpaQueryFactory
                .selectFrom(user)
//                .where(user.useYn.eq("Y"))
                .fetch();
    }
    // 사용자 검색 조건에 따른 데이터 조회
    @Override
    public List<User> searchUsers(String userNm, String userId, String regiUser, String updaUser,
                                  LocalDateTime regiDtFrom, LocalDateTime regiDtTo, LocalDateTime updaDtFrom, LocalDateTime updaDtTo) {
        QUser user = QUser.user;

        return jpaQueryFactory
                .selectFrom(user)
                .where(
                        user.useYn.eq("Y"),
                        likeOrNull(user.userNm, userNm),
                        likeOrNull(user.userId, userId),
                        likeOrNull(user.regiUser, regiUser),
                        likeOrNull(user.updaUser, updaUser),
                        betweenOrNull(user.regiDt, regiDtFrom, regiDtTo),
                        betweenOrNull(user.updaDt, updaDtFrom, updaDtTo)
                )
                .fetch();
    }
    // 사용자 검색 조건에 등록일과 계정 수로 그룹화한 데이터 결과
    @Override
    public List<Tuple> groupBySearch(String userNm, String userId, String regiUser, String updaUser,
                                     LocalDateTime regiDtFrom, LocalDateTime regiDtTo, LocalDateTime updaDtFrom, LocalDateTime updaDtTo) {
        QUser user = QUser.user;

        return jpaQueryFactory
                .select(user.regiDt.stringValue().substring(0, 10), user.userNm.count())
                .from(user)
                .where(
                        user.useYn.eq("Y"),
                        likeOrNull(user.userNm, userNm),
                        likeOrNull(user.userId, userId),
                        likeOrNull(user.regiUser, regiUser),
                        likeOrNull(user.updaUser, updaUser),
                        betweenOrNull(user.regiDt, regiDtFrom, regiDtTo),
                        betweenOrNull(user.updaDt, updaDtFrom, updaDtTo)
                )
                // 날짜를 yyyy-MM-dd 형식으로 그룹화
                .groupBy(user.regiDt.stringValue().substring(0, 10))
                .fetch();

    }

    // Helper method: like 조건 처리
    private BooleanExpression likeOrNull(StringPath path, String value) {
        if (value.equals("")) {
            // 검색값이 null이면, path가 null인 값도 포함
            return path.isNull().or(path.isNotNull());
        }
        // 검색값이 null이 아니면 containsIgnoreCase 조건 적용
        return path.containsIgnoreCase(value);
    }

    // Helper method: between 조건 처리
    private BooleanExpression betweenOrNull(DateTimePath<LocalDateTime> path, LocalDateTime from, LocalDateTime to) {
        System.out.println(path +" "+from+" "+to);
        if (from == null && to == null) return null;
        if (from == null) return path.loe(to);
        if (to == null) return path.goe(from);
        return path.between(from, to);
    }


}
