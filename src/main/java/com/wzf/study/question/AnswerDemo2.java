package com.wzf.study.question;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther: 王振方
 * @date: 2024 03 08 12 30
 * @description:
 */
public class AnswerDemo2 {
    /**
     * 有两个线程，需要轮训依次将1～10打印出来
     * Thread 实现
     * @param args
     */
    public static void main(String[] args) {
        AtomicInteger s = new AtomicInteger(1);
        AtomicInteger e = new AtomicInteger(10);
        Thread t1 = new MyThread(s,e);
        Thread t2 = new MyThread(s,e);
        t1.start();
        t2.start();
    }
}

class MyThread extends Thread{
    private AtomicInteger start ;
    private AtomicInteger end ;

    public MyThread(AtomicInteger start, AtomicInteger end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        while (start.get() <= end.get()){
            prt();
        }
    }

    void prt(){
        synchronized (MyThread.class) {
            try {
                System.out.println(Thread.currentThread().getName() + "--" + start.get());
                start.incrementAndGet();
                MyThread.class.notify();
                if(start.get() <= end.get()){
                    MyThread.class.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
