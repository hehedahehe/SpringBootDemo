package com.cesuokanc.multithread.jdk;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @author liruibo
 * @date 2018/7/6
 */
public class ArrayBlockingQueueTest extends BlockQueueTest {

    @Before
    public void initResource() {
        arrayBlockQueue.add(new DemoTask("task1"));
        arrayBlockQueue.add(new DemoTask("task2"));
        arrayBlockQueue.add(new DemoTask("task3"));
        arrayBlockQueue.add(new DemoTask("task4"));
        arrayBlockQueue.add(new DemoTask("task5"));
    }

    @Test
    public void testPeek() {
        System.out.println(arrayBlockQueue.peek().getName());
        System.out.println(arrayBlockQueue.peek().getName());
        System.out.println(arrayBlockQueue.peek().getName());
        System.out.println(arrayBlockQueue.peek().getName());
        System.out.println(arrayBlockQueue.peek().getName());
        Assert.assertTrue(arrayBlockQueue.size() == 5);

    }


    @Test
    public void testPoll() {
        System.out.println(arrayBlockQueue.poll().getName());
        System.out.println(arrayBlockQueue.poll().getName());
        System.out.println(arrayBlockQueue.poll().getName());
        System.out.println(arrayBlockQueue.poll().getName());
        System.out.println(arrayBlockQueue.poll().getName());
        Assert.assertTrue(arrayBlockQueue.size() == 0);
    }


    @Test
    public void testTask() throws Exception {
        System.out.println(arrayBlockQueue.take().getName());
        System.out.println(arrayBlockQueue.take().getName());
        System.out.println(arrayBlockQueue.take().getName());
        System.out.println(arrayBlockQueue.take().getName());
        System.out.println(arrayBlockQueue.take().getName());
        Assert.assertTrue(arrayBlockQueue.size() == 0);
    }


    @Test
    public void testSimpleProducerAndConsumer() {

        Thread producer = new Producer(oridinaryQueue);

        Thread consumer1 = new Consumer<>(oridinaryQueue,1);
        Thread consumer2 = new Consumer<>(oridinaryQueue,2);

        producer.start();
        consumer1.start();
        consumer2.start();

        try {
            producer.join();
            consumer1.join();
            consumer2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("===>");
        Set<Integer> ids1 = ((Consumer) consumer1).getTaskRecords();
        Set<Integer> ids2 = ((Consumer) consumer2).getTaskRecords();
        ids1.retainAll(ids2);
        System.out.println(ids1);

    }


    public static class Consumer<T extends DemoTask> extends Thread {

        private Set<Integer> taskRecords = new HashSet<>();
        private Queue<T> queue;
        private int id;

        public Consumer(Queue<T> queue, int id) {
            this.queue = queue;
            this.id = id;
        }

        public Set<Integer> getTaskRecords(){
            return taskRecords;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Random random = new Random();
                    Thread.sleep(random.nextInt(10));
                    T t = queue.poll();
                    if (t != null) {
                        taskRecords.add(t.getId());
                        System.out.println("consumer "+this.id+" consuming....消费了"+taskRecords.size()+"个任务。");
                        if(taskRecords.size()>200){
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("====>Interrupted...");
                }
            }
        }
    }


    public static class Producer extends Thread {
        private Queue<DemoTask> queue;
        private int count = 0;
        public Producer(Queue<DemoTask> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Random random = new Random();
                    Thread.sleep(random.nextInt(10));
                    DemoTask demoTask = new DemoTask(random.nextInt(100000));
                    System.out.println("producing...." + demoTask.getId() + "===="+queue.size()+"个任务");
                    queue.add(demoTask);
                    count++;
                    if(count==1000){
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("====>Interrupted...");
                }
            }
        }
    }


}
