package com.example.springbootmybatismysql.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

    private int id;
    private String name;
    private int age;
}
