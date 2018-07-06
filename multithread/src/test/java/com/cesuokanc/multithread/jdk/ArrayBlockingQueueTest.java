package com.cesuokanc.multithread.jdk;

import org.junit.Before;
import org.junit.Test;

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
    }


    @Test
    public void testPoll(){
        System.out.println(arrayBlockQueue.poll().getName());
        System.out.println(arrayBlockQueue.poll().getName());
        System.out.println(arrayBlockQueue.poll().getName());
        System.out.println(arrayBlockQueue.poll().getName());
        System.out.println(arrayBlockQueue.poll().getName());
    }


    @Test
    public void testTask() throws Exception{
        System.out.println(arrayBlockQueue.take().getName());
        System.out.println(arrayBlockQueue.take().getName());
        System.out.println(arrayBlockQueue.take().getName());
        System.out.println(arrayBlockQueue.take().getName());
        System.out.println(arrayBlockQueue.take().getName());
    }

}
