package com.cesuokanc.multithread.collections;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/*
*
*@author lirb
*@email 12465311242@qq.com
*@date 2018/6/29
*/
public class BaseDemo {

    public static class DemoTask implements Delayed {

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
