package com.jk.code.week4;

/**
 * @author ：qiyingx.xiao
 * @date ：Created in 2021-05-30 15:52
 * @description： TODO
 * @modified By：0.0
 * @version: 1.0.0
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 *
 * 一个简单的代码参考：
 */

public class q2_2 {
    // 创建一个线程池
    static ExecutorService pool = Executors.newFixedThreadPool(10);  //线程池默认容量为10个线程

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        FutureTask futureTask = new FutureTask(() -> sum());

        Future<Integer> submit = pool.submit(() -> sum());

        System.out.println(submit.get());

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    private static int sum() {
        return fibo(1);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
