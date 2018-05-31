package com.example.springbootmybatismysql.mapper;

import com.example.springbootmybatismysql.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {
    int insertAdmin(@Param("account") String account, @Param("password") String password);

    Admin selectAdminByAccount(String account);
}
