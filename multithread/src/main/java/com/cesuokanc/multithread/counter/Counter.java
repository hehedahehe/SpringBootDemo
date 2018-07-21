package com.cesuokanc.multithread.counter;

/**
 *
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/interfere.html
 * @author liruibo
 * @date 2018/7/18
 */
public class Counter {
    private int c = 0;

    public void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }

    public static void main(String[] args)throws InterruptedException{
        long begin = System.currentTimeMillis();
        Counter counter = new Counter();
        int times = 1000000;
        Thread t1 = new Thread(()->{
           for(int i=0;i<times;i++){
               counter.increment();
           }
        });
        Thread t2 = new Thread(()->{
            for(int i=0;i<times;i++){
                counter.decrement();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println((end-begin)+"====>"+counter.value());

    }
}
