package com.cesuokanc.multithread.component;

import lombok.Data;

/*
*
*@author lirb
*@email 12465311242@qq.com
*@date 2018/6/28
*/
public class QueueTask {

    private long initTime;
    private long endTime;
    private String name;

    public QueueTask(String name, long initTime, long endTime) {
        this.name = name;
        this.initTime = initTime;
        this.endTime = endTime;
    }

    public void doSomething(long doTime){
        System.out.println("task>>>"+this.name+"|"+this.initTime+" | "+this.endTime+"|do something at "+ doTime);
    }


    public long getInitTime() {
        return initTime;
    }

    public void setInitTime(long initTime) {
        this.initTime = initTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
