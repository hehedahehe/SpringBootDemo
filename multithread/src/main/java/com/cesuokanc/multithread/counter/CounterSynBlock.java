package com.cesuokanc.multithread.counter;

/**
 * @author liruibo
 * @date 2018/7/18
 */
public class CounterSynBlock {
    private int c = 0;

    public  void increment() {
        synchronized(this){
            c++;
        }
    }

    public synchronized void decrement() {
        synchronized (this){
            c--;
        }
    }

    public int value() {
        return c;
    }

    public static void main(String[] args)throws InterruptedException{
        long begin = System.currentTimeMillis();

        CounterSynBlock counter = new CounterSynBlock();
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
