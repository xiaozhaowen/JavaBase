package com.imooc.concurrent.daemon;

import java.util.Scanner;

/**
 * Created by knight on 17/3/10.
 */
public class DaemonClient {
    public static void test(){

        DaemonThreadDemo daemonThreadDemo = new DaemonThreadDemo();

        //需要明确指定线程为后台线程
        daemonThreadDemo.setDaemon(true);
        daemonThreadDemo.start();

        /**
         * 这样的话,主线程会阻塞,直到用户在控制台做出输出
         */
        Scanner scanner = new Scanner(System.in);
        scanner.next();


        System.out.println("主线程结束");
    }
}
