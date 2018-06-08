package com.cesuokanc.druid.mdo;

import lombok.Data;

import java.util.Date;

/*
*
*@author lirb
*@email 12465311242@qq.com
*@date 2018/6/5
*/
@Data
public class User {
    private Integer id;
    private Integer age;
    private String name;
    private Date birthday;

    public User(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public User(){super();}
}
