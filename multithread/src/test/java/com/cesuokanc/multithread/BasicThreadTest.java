package com.cesuokanc.multithread;


import org.junit.Test;

/*
*
*@author lirb
*@email 12465311242@qq.com
*@date 2018/6/28
*/
public class BasicThreadTest {

    @Test
    public void testJoin() throws InterruptedException{
        Thread t1 = new Thread(new MyRunnable("t1"));
        Thread t2 = new Thread(new MyRunnable("t2"));
        Thread t3 = new Thread(new MyRunnable("t3"));
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        t3.start();
        t3.join();

//        t1.join();
//        t2.join();
//        t3.join();

    }


    public class MyRunnable implements Runnable{

        private String name;

        public MyRunnable(String name){
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(">>>"+this.name);
        }
    }
}
