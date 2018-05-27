package com.example.springbootmybatismysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springbootmybatismysql.mapper")
public class SpringbootMybatisMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisMysqlApplication.class, args);
	}
}