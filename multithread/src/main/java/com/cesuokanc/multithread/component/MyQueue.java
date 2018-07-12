package com.cesuokanc.multithread.component;

import org.springframework.util.Assert;

import java.util.LinkedList;
import java.util.List;

/**
 *
 *@author lirb
 *@email 12465311242@qq.com
 *@date 2018/6/28
 */
public class MyQueue{

    private Checker checker = new Checker();

    private List<QueueTask> tasks = new LinkedList<>();

    private long activeTaskCount=0;

    public MyQueue  addTask(QueueTask queueTask){
        this.tasks.add(queueTask);
        this.activeTaskCount++;
        return this;
    }

    /**
     * 开始调度
     */
    public void startSchedule() throws InterruptedException{
        Thread thread = new Thread(this.checker);
        thread.start();
        thread.join();
    }


    class Checker implements Runnable{
        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            System.out.println("调度器>>> " + thread.getName() + " | " +thread.getId());
            Assert.isTrue(tasks.size()>0,"未设置task.");
            while (tasks.size()>0){
                for(int i=0;i<tasks.size();i++){
                    QueueTask queueTask = tasks.get(i);
                    if(System.currentTimeMillis()>=queueTask.getEndTime()){
                        queueTask.doSomething(System.currentTimeMillis());
                        tasks.remove(i);
                    }
                }
            }
        }
    }





}
