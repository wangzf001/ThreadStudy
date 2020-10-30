package com.wzf.study.provideconsume;

/**
 * @author 王振方
 * @date 2020/10/30
 */
public class Provider extends Thread{

    private Factory factory;

    public Provider(Factory factory) {
        this.factory = factory;
    }

    void set(){
        while (true) {
            factory.set();
        }
    }

    @Override
    public void run() {
        set();
    }
}
