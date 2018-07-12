package com.cesuokanc.multithread.jdk;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 *
 *@author lirb
 *@date 2018/6/29
 */
public class BaseTest {


    public static class DemoTask implements Delayed {

        private String name;
        private Integer id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId(){
            return this.id;
        }
        public DemoTask(String name){
            this.name = name;
        }

        public DemoTask(Integer id){
            this.id = id;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }

        @Override
        public String toString() {
            return "DemoTask{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
