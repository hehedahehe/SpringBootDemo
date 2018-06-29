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
public class MapDemo  extends BaseDemo{

    /**
     * map
     */
    private Map<String,BaseDemo.DemoTask> concurrentHashMap = new ConcurrentHashMap<>();
    private Map<String, BaseDemo.DemoTask> concurrentSkipListMap = new ConcurrentSkipListMap<>();


}
