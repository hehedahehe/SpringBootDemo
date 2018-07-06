package com.cesuokanc.multithread.jdk;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 *
 *@author lirb
 *@date 2018/6/29
 */
public class BaseTest {


    public static class DemoTask implements Delayed {

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;

        public DemoTask(String name){
            this.name = name;
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
