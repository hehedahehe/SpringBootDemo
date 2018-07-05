package com.cesuokanc.multithread.jdk;

import com.cesuokanc.multithread.collections.BaseDemo;

import java.util.Queue;
import java.util.concurrent.*;

/**
 * A demo For BlockingQueue.
 * The interface has implements as following:
 * 1. ArrayBlockingQueue,
 * 2. DelayQueue,
 * 3. LinkedBlockingQueue,
 * 4. LinkedTransferQueue,
 * 5. PriorityBlockingQueue,
 * 6. SynchronousQueue,
 * 7. LinkedBlockingDeque
 * 8. org.apache.tomcat.util.threads.TaskQueue (a third-party(tomcat) implement)
 *
 * @author lirb
 * @email 1246531124@qq.com
 * @date 2018/6/29
 */
public class BlockQueueTest extends BaseDemo {

    /**
     * Queue
     */
    protected Queue<DemoTask> deque = new ConcurrentLinkedDeque<>();
    private Queue<DemoTask> queue = new ConcurrentLinkedQueue<>();


    /**
     * Queue -> BlockingQueue
     */
    private BlockingQueue<DemoTask> delayBlockQueue = new DelayQueue<>();
    private BlockingQueue<DemoTask> arrayBlockQueue = new ArrayBlockingQueue<>(10);
    private BlockingQueue<DemoTask> linkedBlockQueue = new LinkedBlockingQueue<>();
    private BlockingQueue<DemoTask> linkedTransferQueue = new LinkedTransferQueue<>();
    private BlockingQueue<DemoTask> priorityBlockingQueue = new PriorityBlockingQueue<>();
    private BlockingDeque<DemoTask> linkedBlockDeque = new LinkedBlockingDeque<>();

    /**
     * BlockingQueue -> SynchronousQueue
     */
    private SynchronousQueue<DemoTask> synchronousQueue = new SynchronousQueue<>();


    /**
     * 第三方实现
     */
    //org.apache.tomcat.util.threads.TaskQueue -- Tomcat

}
