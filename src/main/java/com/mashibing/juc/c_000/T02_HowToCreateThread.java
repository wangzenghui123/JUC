package com.mashibing.juc.c_000;

import java.util.concurrent.TimeUnit;

//如何创建线程
// 1.继承Thread 类 ，重写run方法
// 2.实现Runnable 接口，实现run方法
// 3.用lamda 表达式
    public class T02_HowToCreateThread {
        public static class T1 extends Thread{
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        TimeUnit.MICROSECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T1");
                }

            }
        }
        public static class T2 implements Runnable{
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        TimeUnit.MICROSECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("T2");
            }
        }
    public static void main(String[] args) {
            new T1().start();
            new Thread(new T2()).start();
            new Thread(()->{
                for (int i = 0; i < 10; i++) {
                    try {
                        TimeUnit.MICROSECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("main");
            }).start();
    }

}
