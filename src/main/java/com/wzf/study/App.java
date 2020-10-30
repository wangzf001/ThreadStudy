package com.wzf.study;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        /**
         * i++ 即后加加，原理是：先自增，然后返回自增之前的值
         * ++i 即前加加，原理是：先自增，然后返回自增之后的值
         * 	https://blog.csdn.net/android_cai_niao/article/details/106027313
         */
        int i=0;
        int a=0;
        i++;
        a=i;
        System.out.println(i);
        System.out.println(a);
        i=i++;
        System.out.println(i);
        i=i++;
        System.out.println(i);

//        int i=1,a=0;
//        System.out.println("a=i++===>  "+(a=i++));//1
        //System.out.println("a=++i===>  "+(a=++i));//2


//        Integer a = 129;
//        Integer b = 129;
//        Integer c = 127;
//        Integer d = 127;
//        System.out.println(a==b);
//        System.out.println(c==d);




    }
}
