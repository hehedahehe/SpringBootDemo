package com.cesuokanc.multithread.framework;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author liruibo
 * @date 2018/7/5
 */
public class ExecutorServiceTest {

    @Test
    public void test1() throws Exception{
        long begin = System.currentTimeMillis();
        List<Integer> res = new LinkedList<>();
        List<Integer> data = Lists.newArrayList(1,2,3,4,5,6);
        CountDownLatch countDownLatch = new CountDownLatch(data.size());
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        data.stream().forEach(x->executorService.submit(new FutureTask<Integer>(()->{
            Thread.sleep(1000);
            return x;
        }){
            @Override
            protected void done(){
                System.out.println("==>task"+x+"结束");
                countDownLatch.countDown();
//                System.out.println("==>计数器减一");
                try{
                    res.add(this.get());
                }catch (Exception e){
                    //
                }
            }
        }));
        long end = System.currentTimeMillis();
        /**
         * 等待3秒
         */
        countDownLatch.await(3,TimeUnit.SECONDS);
        System.out.println("耗时："+(end-begin+0.0)/1000 + "s");

//        res.forEach(x-> System.out.println(x));
    }
}
