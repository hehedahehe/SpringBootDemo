package com.cesuokanc.multithread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
*
*@author lirb
*@email 12465311242@qq.com
*@date 2018/6/29
*/
public class ThreadPoolTest {

    @Test
    public void testExecutorService(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
    }
}
