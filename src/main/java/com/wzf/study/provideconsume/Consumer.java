package com.wzf.study.provideconsume;

import java.util.Random;

/**
 * @author 王振方
 * @date 2020/10/30
 */
public class Consumer implements Runnable {

    private Factory factory;

    public Consumer(Factory factory) {
        this.factory = factory;
    }

    void get(){
        while (true) {
            factory.get();
        }
    }

    @Override
    public void run() {
        get();
    }
}
