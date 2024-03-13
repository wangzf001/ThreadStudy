package com.wzf.study.question;

/**
 * @auther: 王振方
 * @date: 2024 03 08 12 21
 * @description:
 */
public class AnswerDemo {
    /**
     * 有两个线程，需要轮训依次将1～10打印出来
     * Runnable 实现
     * @param args
     */
    public static void main(String[] args) {
        Runnable r =  new PConsumer(1,10);
        Thread t1 = new Thread(r,"线程1");
        Thread t2 = new Thread(r,"线程2");
        t1.start();
        t2.start();
    }

}

class PConsumer implements Runnable{
    private int start;
    private int end ;

    public PConsumer(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        while (start <= end){
            synchronized (this){
                try {
                    System.out.println(Thread.currentThread().getName()+ ":"+start);
                    start++;
                    notifyAll();
                    if(start <= end){
                        wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}