package com.cesuokanc.multithread.volatil;


/**
 * @author liruibo
 * @date 2018/7/20
 */
public class SingletonVolatile {
    private volatile static SingletonVolatile instance;


    public static SingletonVolatile getInstance(){
        if (instance == null) {
            synchronized (SingletonVolatile.class) {
                if (instance == null) {
                    instance = new SingletonVolatile();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonVolatile.getInstance();
    }

}
