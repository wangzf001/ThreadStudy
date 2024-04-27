package com.wzf.study.question;

import com.google.common.collect.Lists;
import com.wzf.study.jdk8.User;
import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

/**
 * @auther: 王振方
 * @date: 2024 04 27 16 12
 * @description: 将数据分批进行并发处理，并获取结果
 * 问题：如何优先处理 先处理完成的子线程的数据？ 当子线程完成，做唤醒轮训判断已完成的子任务并获取数据进行处理。
 */
public class PartitionTask {

    public static void main(String[] args) {
        List<User> collectionOrder = Collections.EMPTY_LIST;
        try {
            cal(collectionOrder,3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> cal(List<User> collectionOrder,int num) throws Exception {
        List<String> rspList = new ArrayList<>();
        try {
            // task任务集合
            List<FutureTask<List<String>>> taskList = new ArrayList<>();
            collectionOrder.stream()
                    .collect(Collectors.groupingBy(user->StringUtils.isEmpty(user.getSex())))
                    .entrySet()
                    .forEach(p -> {
                            Lists.partition(p.getValue(), num).forEach(
                                part -> {
                                    FutureTask<List<String>> task;
                                    if (p.getKey()) {
                                        task = new FutureTask<>(() -> part.parallelStream().map(User::getName).collect(Collectors.toList()));
                                    } else {
                                        task = new FutureTask<>(() -> part.parallelStream().map(User::getSex).collect(Collectors.toList()));
                                    }
                                    taskList.add(task);
                                    Executors.newFixedThreadPool(5).submit(task);
                                });
                        }
                    );
            // 收集结果，统一返回
            for (FutureTask<List<String>> t : taskList) {
                List<String> res = t.get();
                rspList.addAll(res);
            }
        } catch (Exception e) {
            throw new Exception();
        }
        return rspList;
    }

}
