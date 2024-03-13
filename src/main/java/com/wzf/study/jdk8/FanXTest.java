package com.wzf.study.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @auther: 王振方
 * @date: 2023 03 16 11 27
 * @description: 泛型学习
 */
public class FanXTest<T,R> {


    public static void main(String[] args) {
       Predicate<String> p = (item)->item.equals("1");
        System.out.println(p.test("2"));

       String a = Optional.of("a").orElseThrow(()->{return null;});

        Thread t = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        });

        List<User> list = Arrays.asList(new User(1,"aaa","男"),new User(2,"bbb","男"),new User(3,"ccc","女"));
//        list.stream().collect(Collectors.groupingBy(User::getSex));


        User u1 = new User();
        User u2 = new User();
        u1.equals(u2);
    }

    protected <T> Function<T,R> get(T t){
        return (T a)->{return null;};
    }



}
