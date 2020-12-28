package com.mashibing.juc.c_000;

import java.util.concurrent.Executors;

public class T03_Sleep_Yield_Join {

    public static void main(String[] args) {

//        Test test = new Test();
//        new Thread(()->{
//            test.even();
//        }).start();
//        new Thread(()->{
//            test.odd();
//        }).start();
    }
}

class Test{
    public  int num = 100;
    Object object = new Object();
    public Test(){}
    public void odd(){
        synchronized (object){
                while(true){
                    if(num > 0 && num % 2 == 1){
                        System.out.println(Thread.currentThread().getName()+"\t"+num--);

                        //if(num == 0)break;
                        //关键在于notify 与 wait的含义
                        //wait  之后必须被唤醒，否则线程不会运行
                        //必须notify在前面，wait在后。如果wait在前，object在调用wait之后，object无法使用
                        //正确理解锁与线程的关系
                        //object调用wait，notify是对线程起作用

                        object.notify();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(num == 0)break;
//                    object.notify();
//                    try {
//                        object.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                }

            object.notify();
        }
    }
    public void even(){
        synchronized (object){
                while(true){
                    if(num > 0 && num % 2 == 0){
                        System.out.println(Thread.currentThread().getName()+"\t"+num--);
                        //if(num == 0)break;
                        object.notify();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(num == 0)break;
//                    object.notify();
//                    try {
//                        object.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }


            object.notify();
        }
    }
}
