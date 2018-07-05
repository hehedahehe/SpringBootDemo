package com.cesuokanc.json;

import lombok.Data;

import java.util.List;

/**
 * @author liruibo
 * @date 2018/7/5
 */
public interface PersonInfoService {

    @Data
    class PersonInfo {

        private Integer age;
        private String name;
        private School school;
        private List<Role> roles;

        public PersonInfo(){}

        public PersonInfo(String name, Integer age){
            this.name = name;
            this.age = age;
        }

        @Data
        public  static class School{
            public static int STATE = 1;
            public School(){}
            public School(Integer id, String name){
                this.id = id;
                this.name = name;
            }
            private Integer id;
            private String name;
        }

        @Data
        public static class Role{
            private Integer id;
            private String name;
            public Role(Integer id, String name){
                this.id = id;
                this.name = name;
            }
        }
    }

}
