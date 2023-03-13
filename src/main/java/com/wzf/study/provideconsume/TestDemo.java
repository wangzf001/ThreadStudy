package com.wzf.study.provideconsume;


/**
 * @author 王振方
 * @date 2020/10/30
 */
public class TestDemo {

    public static void main(String[] args) {

        Factory factory = new Factory();

        Consumer consumer = new Consumer(factory);
        Thread t = new Thread(consumer,"消费者1");
        Thread t1 = new Thread(consumer,"消费者2");
        Thread t2 = new Thread(consumer,"消费者3");
        t1.start();
        t2.start();
        t.start();


        Provider provider = new Provider(factory);
        Provider provider1 = new Provider(factory);
        Provider provider2 = new Provider(factory);
        provider.setName("生产者1");
        provider1.setName("生产者2");
        provider2.setName("生产者3");
        provider.start();
        provider1.start();
        provider2.start();

    }

}
