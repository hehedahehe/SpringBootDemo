package com.cesuokanc.spring;

import lombok.Data;

/*
*
*@author lirb
*@email 12465311242@qq.com
*@date 2018/6/9
*/
@Data
public class UserService {
    private Integer id;
    private String desc;

    public UserService(){
        System.out.println("==>UserService Initialize...");
    }

}
