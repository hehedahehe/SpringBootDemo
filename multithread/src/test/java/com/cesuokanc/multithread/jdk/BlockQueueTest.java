package com.cesuokanc.multithread.jdk;

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
 * 各自的应用场景都有哪些？
 *
 * @author lirb
 * @email 1246531124@qq.com
 * @date 2018/6/29
 */
public class BlockQueueTest extends BaseTest {

    /**
     * Queue
     */
    protected Queue<DemoTask> deque = new ConcurrentLinkedDeque<>();
    protected Queue<DemoTask> queue = new ConcurrentLinkedQueue<>();


    /**
     * Queue -> BlockingQueue
     */
    protected BlockingQueue<DemoTask> delayBlockQueue = new DelayQueue<>();
    protected BlockingQueue<DemoTask> arrayBlockQueue = new ArrayBlockingQueue<>(10);
    protected BlockingQueue<DemoTask> linkedBlockQueue = new LinkedBlockingQueue<>();
    protected BlockingQueue<DemoTask> linkedTransferQueue = new LinkedTransferQueue<>();
    protected BlockingQueue<DemoTask> priorityBlockingQueue = new PriorityBlockingQueue<>();
    //protected BlockingDeque<DemoTask> linkedBlockDeque = new LinkedBlockingDeque<>();

    /**
     * BlockingQueue -> SynchronousQueue
     */
    protected SynchronousQueue<DemoTask> synchronousQueue = new SynchronousQueue<>();


    /**
     * 第三方实现
     */
    //org.apache.tomcat.util.threads.TaskQueue -- Tomcat

}
