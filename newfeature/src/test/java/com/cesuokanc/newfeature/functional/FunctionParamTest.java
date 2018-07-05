package com.cesuokanc.newfeature.functional;


import org.junit.Test;

/**
 * @author liruibo
 * @date 2018/7/5
 */
public class FunctionParamTest {

    static int i = 10;

    /**
     * 保证1、2签名一致
     */
    @Test
    public void testFunctionalInterface(){
        //1、函数式
        doCal((i) -> System.out.println(i+10));
        //2、匿名类
//        doCal(new ICalculateService() {
//            @Override
//            public void doC(int i) {
//                System.out.println(i+11);
//            }
////            @Override
////            public void doC2(int i) {
////                System.out.println(i+12);
////            }
//        });
    }

    static void doCal(ICalculateService iCalculateService){
        iCalculateService.doC(i);
        iCalculateService.doC2(1000);
    }

    /**
     * https://stackoverflow.com/questions/45466315/why-not-multiple-abstract-methods-in-functional-interface-in-java8/45467070
     * 优点是在不用创建该接口的实现类、匿名类的情况下实现该接口的功能。
     *
     * 函数式只能匹配一个接口方法（对外），所以需要明哪个方法来使用函数式来实现
     * 此时接口中其他方法必须有默认的实现。在Java8中可采用关键字default提供默认实现
     */
    @FunctionalInterface
    interface ICalculateService{
        void doC(int i);
        //void doC2(int i); //不能存在第二个没有具体实现的接口
        default void doC2(int i){
            System.out.println(i+"fsfds");
        }
    }


}
