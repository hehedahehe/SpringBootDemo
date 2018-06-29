package com.cesuokanc.multithread.collections;

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
public class SetDemo extends BaseDemo {

    /**
     * set
     */
    private Set<DemoTask> concurrentSkipListSet = new ConcurrentSkipListSet<>();
    private Set<DemoTask> copyOnWriteArraySet = new CopyOnWriteArraySet<>();



}
