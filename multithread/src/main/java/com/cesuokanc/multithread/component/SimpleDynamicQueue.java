package com.cesuokanc.multithread.component;

import java.util.LinkedList;
import java.util.List;

/**
 *
 *@author lirb
 *@email 12465311242@qq.com
 *@date 2018/6/28
 */
public class SimpleDynamicQueue {

    private TaskChecker checker = new TaskChecker();
    private Thread thread = new Thread(this.checker);
    private List<QueueTask> tasks = new LinkedList<>();

    /**
     * 开始调度
     */
    public void startSchedule() throws InterruptedException{
        thread.start();
    }

    public void join() throws InterruptedException{
        this.thread.join();
    }

    public int size(){
        return this.tasks.size();
    }


    private synchronized void doTask(int index) {
        QueueTask queueTask = tasks.get(index);
        if(System.currentTimeMillis()+100000>=queueTask.getEndTime()){
            queueTask.doSomething(System.currentTimeMillis());
            tasks.remove(index);
        }
    }

    public synchronized SimpleDynamicQueue addTask(QueueTask queueTask){
        this.tasks.add(queueTask);
        return this;
    }



    class TaskChecker implements Runnable{
        @Override
        public void run() {
            while (true){
                for(int i=0;i<tasks.size();i++){
                    doTask(i);
                }
            }
        }
    }


}
