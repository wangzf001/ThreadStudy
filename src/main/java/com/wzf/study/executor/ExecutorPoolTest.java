package com.wzf.study.executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther: 王振方
 * @date: 2024 03 07 19 04
 * @description:
 */
public class ExecutorPoolTest {

    /**
     * 线程池的使用练习
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //练习线程池的基本使用，了解核心参数
        exParamsTest();
        //练习常见线程池及submit()方法
        executorsTest();
    }


    /**
     * 练习线程池的基本使用，了解核心参数
     * @throws InterruptedException
     */
    static void exParamsTest() throws InterruptedException {
        int total = 1000;
        CountDownLatch c = new CountDownLatch(total);
        AtomicInteger a = new AtomicInteger(0);
        /**
         * 核心参数： 核心线程池数、最大线程池数、存活时间、阻塞队列
         */
        ThreadPoolExecutor executor =  new ThreadPoolExecutor(3,5,5, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        for (int i = 0; i < total; i++) {
            executor.execute(()->{
                a.incrementAndGet();
                c.countDown();
            });
        }
        c.await();
        System.out.println("结束"+a.get());
        executor.shutdown();
    }

    /**
     * 练习常见线程池及submit()方法
     * @throws ExecutionException
     * @throws InterruptedException
     */
    static void executorsTest() throws ExecutionException, InterruptedException {
        //固定线程数线程池
        ExecutorService e1 =  Executors.newFixedThreadPool(5);
        /**
         * submit()返回Future值，execute()无返回值
         */
        Future future = e1.submit(()-> {
            return 1;
        });
        System.out.println(Thread.currentThread().getName()+"--"+future.get());

        //缓存线程池，无核心线程数，最大线程数为Integer.MAX_VALUE
        ExecutorService e2 =  Executors.newCachedThreadPool();
        //单线程线程池
        ExecutorService e3 =  Executors.newSingleThreadExecutor();
        //延迟线程池，默认延时10毫秒
        ExecutorService e4 =  Executors.newScheduledThreadPool(5);
    }



}
