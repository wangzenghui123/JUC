//fori for循环快捷键
//try catch 快捷键 crtl alt + T
//继承父类方法 ALT + Insert

package com.mashibing.juc.c_000;

import java.util.concurrent.TimeUnit;

public class T01_WhatisThread {
    public static class T1 extends Thread{
        @Override
        public void run() {
            for(int i = 0;i < 10;i++){
                System.out.println("T1");
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                    //Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    public static void main(String[] args) {
        new T1().start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main");
            try {
                TimeUnit.MICROSECONDS.sleep(1);
                //Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
