package com.cesuokanc.multithread;

import org.junit.Test;

/*
*
*@author lirb
*@email 12465311242@qq.com
*@date 2018/6/29
*/
public class ExtendsTest {
    static class A{
        public void doSomething(){
            doB();
            doC();
        }

        public void doB(){}
        public void doC(){}
    }

    static class B extends A{

        @Override
        public void doB(){
            System.out.println("doB in B");
        }

        @Override
        public void doC(){
            System.out.println("doC in B");
        }
    }

    @Test
    public void testMp(){
        A a = new B();
        a.doSomething();
    }
}
