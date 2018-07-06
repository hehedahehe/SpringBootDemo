package com.cesuokanc.multithread.collections;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 *
 *@author lirb
 *@date 2018/6/29
 */
public class BaseDemo {


    @Data
    public static class DemoTask implements Delayed {

        private String name;

        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }

}
