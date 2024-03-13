package com.wzf.study.suanfa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @auther: 王振方
 * @date: 2023 03 20 14 37
 * @description:
 */
public class DiguiTest {

    private static int g = 0;//盖子
    private static int k = 0;//空瓶
    private static int num = 0;//总数

    public static void main(String[] args) {
       calc(10,0,0);

        HashSet<Integer> set = new HashSet<>();
        set.add(1);

        LinkedList linkedList = new LinkedList();
        linkedList.add(1);

        ArrayList<Integer> list = new ArrayList<>(5);
        list.add(Integer.valueOf(1));
    }

    /**
     * 2元1瓶、4盖一瓶、2空瓶一瓶
     * 计算出剩余金额，总共喝了多少瓶，剩多少个盖子、空瓶
     * @param money
     * @param g
     * @param k
     */
     public static void calc(int money,int g,int k){
        int newNum = 0;
        if(money >= 2){
            newNum = newNum + money/2;
            money = money%2;
        }
        if(g >= 4){
            newNum = newNum + g/4;
            g = g%4;
        }
        if(k >= 2){
            newNum = newNum + k/2;
            k = k%2;
        }
         num += newNum;
         g += newNum;
         k += newNum;
         if(g >= 4 || k >= 2){
             calc(money,g,k);
         }else{
             System.out.println("总共瓶数："+num+"；空瓶子剩余："+k+"；盖子剩余："+g);
         }
     }




}
