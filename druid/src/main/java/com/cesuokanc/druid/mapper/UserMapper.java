package com.cesuokanc.druid.mapper;

import com.cesuokanc.druid.mdo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/*
*
*@author lirb
*@email 12465311242@qq.com
*@date 2018/6/5
*/
public interface UserMapper {

    @Insert("insert into users(user_name,user_age,birthday) values(#{name},#{age},#{birthday})")
    void insert(User user);

    @Select("select id, user_name as name , user_age as age , birthday from users WHERE id=#{id}")
    User findById(Integer id);

    @Select("select id,user_name as name , user_age as age , birthday from users")
    List<User> findAll();
}
