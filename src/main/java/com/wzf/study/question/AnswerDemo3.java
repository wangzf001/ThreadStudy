package com.wzf.study.question;

import java.util.concurrent.*;

/**
 * @auther: 王振方
 * @date: 2024 03 08 21 01
 * @description:
 */
public class AnswerDemo3 implements Callable<Integer> {

    int times = 1;
    int total = 10;

    @Override
    public Integer call() throws Exception {
        while(times <= total) {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + "--" + times);
                times++;
                notify();
                if(times <= total){
                    wait();
                }
            }
        }
        return times;
    }

    /**
     * 有两个线程，需要轮训依次将1～10打印出来
     * Callable 实现
     * 两种方式
     * new Thread(new FutureTask(new Callable(){})).start();
     * Future f = executor.submit(new Callable(){})
     * @param args
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable callable  =  new AnswerDemo3();
        FutureTask ft1 = new FutureTask<Integer>(callable);
        FutureTask ft2 = new FutureTask<Integer>(callable);
        new Thread(ft1).start();
        new Thread(ft2).start();
        System.out.println(ft1.get());
        System.out.println(ft2.get());


        /**
         * 线程池使用 Future
         */
        Future future =  Executors.newFixedThreadPool(2).submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            };
        });
        future.get();

        Executors.newFixedThreadPool(2).execute(()->{

        });

    }
}
