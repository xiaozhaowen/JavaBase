package com.imooc.concurrent;

import java.util.ArrayList;

/**
 * Created by knight on 17/3/8.
 */
public class Stage extends Thread {
    @Override
    public void run() {
        System.out.println("欢迎观看隋唐演义");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("大幕徐徐拉开");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("话说隋朝末年,隋军与农民起义军啥的昏天黑地...");

        Army army_sui = new Army();
        Army army_revolt = new Army();

        //使用Runnable接口创建线程
        Thread suiArmy = new Thread(army_sui,"隋朝军队");
        Thread revoltArmyT = new Thread(army_revolt,"农民起义军");

        //启动线程,让军队开始作战
        suiArmy.start();
        revoltArmyT.start();

        //舞台线程休眠,大家专心观看军队厮杀
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("正当双方激战正酣,半路杀出个程咬金");
        Thread chengYaoJin = new Hero();
        chengYaoJin.setName("程咬金");

        //停止军队作战,停止线程的方法
        army_sui.keepRunning = false;
        army_revolt.keepRunning = false;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //历史大戏留给关键人物
        chengYaoJin.start();

        //万众瞩目,所有线程等待英雄人物完成历史使命
        try {
            chengYaoJin.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("程咬金大杀四方,平定战乱");
        System.out.println("谢谢观看隋唐演义");
    }

    public static void  test(){
        new Stage().start();
    }
}
