package com.cesuokanc.multithread;

import org.junit.Test;

import java.util.concurrent.*;

/*
*
*@author lirb
*@email 12465311242@qq.com
*@date 2018/6/29
*
*/
public class FutureTaskTest {

    //共享资源池
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Test
    public void testCallable(){

        Callable<Integer> callable = ()-> { return 1;};
        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        FutureTaskTest.submitTaskToThread(futureTask).start();

        try {
            //对get方法进行调用会发生阻塞。为什么调用get时会发生阻塞?
            System.out.println(futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testRunnable(){
        FutureTaskTest.submitTaskToThread(()->{
            System.out.println(123);
        }).start();
    }


    @Test
    public void testExecutorService(){
        Callable<Integer> callable = ()-> { return 1;};
        Future<Integer> res = FutureTaskTest.submitTaskToExecutor(callable);
        try {
            System.out.println(res.get());
        } catch (Exception e) {
            FutureTaskTest.shutdownService();
            e.printStackTrace();
        }
    }


    /**
     *交给了一个线程去执行
     * @param runnable
     * @return
     */
    public static Thread submitTaskToThread(Runnable runnable){
        return new Thread(runnable);
    }


    /**
     * 交给一个执行器去执行
     * @param callable
     * @param <T>
     * @return
     */
    public static <T> Future<T> submitTaskToExecutor(Callable<T> callable){
        return executorService.submit(callable);
    }

    public static void shutdownService(){
        executorService.shutdown();
    }


}
