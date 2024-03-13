package com.wzf.study;

import com.wzf.study.provideconsume.Consumer;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        System.out.println(cl.getDefinedPackage(Consumer.class.getName()));

//        for (int i = 0; ;) {
//            System.out.println(i);
//        }

        for (;;) {
            System.out.println(10);
        }
    }
}
