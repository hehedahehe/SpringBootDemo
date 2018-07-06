package com.cesuokanc.multithread.collections;

import java.util.Queue;
import java.util.concurrent.*;

/**
 * @author lirb
 * @date 2018/6/29
 */
public class QueueDemo extends BaseDemo {

    /**
     * queue
     */
    private Queue<DemoTask> deque = new ConcurrentLinkedDeque<>();
    private Queue<DemoTask> queue = new ConcurrentLinkedQueue<>();

    /**
     * blocking queue
     * ArrayBlockingQueue,
     * DelayQueue,
     * LinkedBlockingQueue,
     * LinkedTransferQueue,
     * PriorityBlockingQueue,
     * SynchronousQueue
     */
    private BlockingQueue<DemoTask> delayBlockQueue = new DelayQueue<>();
    private BlockingQueue<DemoTask> arrayBlockQueue = new ArrayBlockingQueue<>(10);
    private BlockingQueue<DemoTask> linkedBlockQueue = new LinkedBlockingQueue<>();
    private BlockingQueue<DemoTask> linkedTransferQueue = new LinkedTransferQueue<>();
    private BlockingQueue<DemoTask> priorityBlockingQueue = new PriorityBlockingQueue<>();
    private SynchronousQueue<DemoTask> synchronousQueue = new SynchronousQueue<>();

    /**
     * blocking deque
     * LinkedBlockingDeque,
     */
    private BlockingDeque<DemoTask> linkedBlockDeque = new LinkedBlockingDeque<>();


    /**
     * 第三方实现
     */
    //org.apache.tomcat.util.threads.TaskQueue -- Tomcat

}
