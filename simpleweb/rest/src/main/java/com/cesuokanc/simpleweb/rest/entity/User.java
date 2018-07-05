package com.cesuokanc.simpleweb.rest.entity;

import lombok.Data;

/**
 * @author liruibo
 * @date 2018/7/5
 */
@Data
public class User {
    private Integer id;
    private String name;
    public User(){}

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
