package com.yureto.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserMapper{
    @Select("SELECT * FROM users WHERE id = #{id}")
    Optional<User> findById(int id);
}
