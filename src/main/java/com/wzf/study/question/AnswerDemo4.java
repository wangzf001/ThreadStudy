package com.wzf.study.question;

/**
 * @auther: 王振方
 * @date: 2024 03 08 22 18
 * @description:
 */
public class AnswerDemo4 {


    public static void main(String[] args) {
        try {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"-新线程插入");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread.yield();
    }
}
