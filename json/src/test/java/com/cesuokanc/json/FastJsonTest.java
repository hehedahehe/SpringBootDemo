package com.cesuokanc.json;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @author liruibo
 * @date 2018/7/5
 */
public class FastJsonTest {


    @Test
    public void testSimpleObjectToJson(){
        PersonInfo p = new PersonInfo("萧红",23);
        PersonInfo.School school = new PersonInfo.School(12,"北京附中");
        p.setSchool(school);
        System.out.println(JSON.toJSON(p));
    }


    @Test
    public void testSimpleJsonToObject(){
        String simpleJson = "{\"school\":{\"name\":\"北京附中\",\"id\":12},\"name\":" +
                "\"萧红\",\"age\":23}";
        PersonInfo p = JSON.parseObject(simpleJson,PersonInfo.class);
        System.out.println(p.getName());
    }


    @Test
    public void testSimpleInnerClassObjectToJson(){
        PersonInfoService.PersonInfo p = new PersonInfoService.PersonInfo("萧红",23);
        PersonInfoService.PersonInfo.School school = new PersonInfoService.PersonInfo.School(12,"北京附中");
        p.setSchool(school);
        System.out.println(JSON.toJSON(p));
    }

    @Test
    public void testSimpleJsonToInnerClassObject(){
        String simpleJson = "{\"school\":{\"name\":\"北京附中\",\"id\":12},\"name\":" +
                "\"萧红\",\"age\":23}";
        PersonInfoService.PersonInfo p = JSON.parseObject(simpleJson,PersonInfoService.PersonInfo.class);
        System.out.println(p.getName());
    }

}
