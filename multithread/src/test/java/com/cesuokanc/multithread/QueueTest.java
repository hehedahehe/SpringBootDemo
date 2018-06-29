package com.cesuokanc.multithread;

import com.cesuokanc.multithread.component.MyQueue;
import com.cesuokanc.multithread.component.QueueTask;
import com.cesuokanc.multithread.component.SimpleDynamicQueue;
import lombok.Data;
import org.junit.Test;

/*
*
*@author lirb
*@email 12465311242@qq.com
*@date 2018/6/28
*/
public class QueueTest {

    /**
     * 一次加载批次处理，不考虑动态加入
     * @throws InterruptedException
     */
    @Test
    public void testBatchQueue() throws InterruptedException{
        System.out.println("主程序>>>"+Thread.currentThread().getName()+" | " + Thread.currentThread().getId());
        MyQueue myQueue = new MyQueue();
        myQueue.addTask(new QueueTask("task1",System.currentTimeMillis(),System.currentTimeMillis()+7001L));
        myQueue.addTask(new QueueTask("task2",System.currentTimeMillis(),System.currentTimeMillis()+1002L));
        myQueue.addTask(new QueueTask("task3",System.currentTimeMillis(),System.currentTimeMillis()+103L));
        myQueue.addTask(new QueueTask("task4",System.currentTimeMillis(),System.currentTimeMillis()+10004L));
        myQueue.addTask(new QueueTask("task5",System.currentTimeMillis(),System.currentTimeMillis()+10505L));
        myQueue.startSchedule();
    }

    /**
     * 考虑读-写同步情况
     */
    @Test
    public void testSimpleDynamicQueue() throws InterruptedException{
        int size = 1000;
        long begin = System.currentTimeMillis();

        Thread mainThread = Thread.currentThread();

        SimpleDynamicQueue myQueue = new SimpleDynamicQueue();
        myQueue.addTask(new QueueTask("task1",System.currentTimeMillis(),System.currentTimeMillis()+7001L));
        myQueue.addTask(new QueueTask("task2",System.currentTimeMillis(),System.currentTimeMillis()+1002L));
        myQueue.addTask(new QueueTask("task3",System.currentTimeMillis(),System.currentTimeMillis()+103L));
        myQueue.addTask(new QueueTask("task4",System.currentTimeMillis(),System.currentTimeMillis()+10004L));
        myQueue.addTask(new QueueTask("task5",System.currentTimeMillis(),System.currentTimeMillis()+10505L));
        Thread.sleep(1000);
        myQueue.startSchedule();
        for(int i=0;i<size;i++){
            myQueue.addTask(new QueueTask("task"+i+"0000",System.currentTimeMillis(),System.currentTimeMillis()+7001L+i));
        }
        myQueue.join();

        long end = System.currentTimeMillis();

        System.out.println(size+"总耗时>>>"+(end-begin)+"ms");
    }


    private SimpleDynamicQueue simpleQueue = new SimpleDynamicQueue();
    private int clientId = 0;

    @Test
    public void mockMultiClientsTest() throws InterruptedException{
        simpleQueue.startSchedule();
        Thread  mockClient1 = new Thread(new MockClient());
        Thread  mockClient2 = new Thread(new MockClient());
        Thread  mockClient3 = new Thread(new MockClient());
        mockClient1.start();
        mockClient2.start();
        mockClient3.start();
        mockClient1.join();
        mockClient2.join();
        mockClient3.join();

        Thread.sleep(10000);
        System.out.println(simpleQueue.size());
    }

    @Data
    class MockClient implements Runnable{
        private int mocClientId;
        public MockClient(){
            mocClientId = ++clientId;
        }

        @Override
        public void run() {
            for(int i=0;i<100;i++) {
                simpleQueue.addTask(new QueueTask("client"+clientId+"---task"+i,System.currentTimeMillis(),System.currentTimeMillis()+10505L));
            }
        }
    }


}
