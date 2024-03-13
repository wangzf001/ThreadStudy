package com.wzf.study.provideconsume;

/**
 * @auther: 王振方
 * @date: 2024 03 05 10 01
 * @description:
 */
public class TestDemo3 {

    /**
     * Thread实现
     * @param args
     */
    public static void main(String[] args) {

       Thread t1 = new MyThread("t1");
       Thread t2 = new MyThread("t2");
       t1.start();
       t2.start();
       Thread.yield();
    }

}

class MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            wait(1);
            join(1);
            sleep(1);

            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}