package com.wzf.study.provideconsume;

/**
 * @author 王振方
 * @date 2020/10/30
 */
public class Factory {

    volatile int total;//拥有数
    static int MAC_VALUE = 200;//最多存储200

    synchronized void get(){
        if(total > 0){
            total--;
            System.out.println(Thread.currentThread().getName()+"--消费1个,total值为"+total);
            notifyAll();
        }else{
            try {
                System.out.println(Thread.currentThread().getName()+"--线程阻塞,total值为"+total);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized void set(){
        if(total < MAC_VALUE){
            total++;
            System.out.println(Thread.currentThread().getName()+"--生产1个,total值为"+total);
            notifyAll();
        }else{
            try {
                System.out.println(Thread.currentThread().getName()+"--线程阻塞,total值为"+total);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
