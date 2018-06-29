package com.cesuokanc.multithread.collections;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.*;

/*
*
*@author lirb
*@email 12465311242@qq.com
*@date 2018/6/29
*/
public class CollectionsDemo {

    private Queue<DemoTask> deque = new ConcurrentLinkedDeque<>();
    private Queue<DemoTask> queue = new ConcurrentLinkedQueue<>();
    private Set<DemoTask> concurrentSkipListSet = new ConcurrentSkipListSet<>();
    private Map<String,DemoTask> concurrentHashMap = new ConcurrentHashMap<>();
    private Map<String, DemoTask> concurrentSkipListMap = new ConcurrentSkipListMap<>();
    private List<DemoTask> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    private Set<DemoTask> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

    private BlockingQueue<DemoTask> delayQueue = new DelayQueue<>();






    public class DemoTask implements Delayed{

        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }
}
