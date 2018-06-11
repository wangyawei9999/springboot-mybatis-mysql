package com.example.springbootmybatismysql.mapper;

import com.example.springbootmybatismysql.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    int insertUser(@Param("id") int id, @Param("name") String name, @Param("age") int age, @Param("avatar") String avatar);

    List<User> selectAllUser();

    User selectUserById(int id);

    int deleteUserById(int id);

    int updateUserById(@Param("id") int id, @Param("name") String name, @Param("age") int age);

}
