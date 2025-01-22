package com.example.Api.user.Repository;

import com.example.Api.user.Entity.User;
import com.querydsl.core.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByUserId(String userId);
}
