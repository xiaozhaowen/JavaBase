package com.mythread;

import org.junit.Test;

/**
 * Created by knight on 17/3/7.
 * <p>
 * 业务场景模拟:
 * <p>
 * 模拟丈夫和妻子拿着银行卡和存折同时去银行取钱
 */


public class BankCustomer implements Runnable{
    public BankCard bc = new BankCard();
    public static void myTest(String[] args) {
        BankCustomer test = new BankCustomer();
        Thread wife = new Thread(test);
        Thread husband = new Thread(test);
        wife.setName("wife");
        husband.setName("husband");
        wife.start();
        husband.start();
    }
    public void run() {
        bc.getMoney(Thread.currentThread().getName(), 2000);
    }
}



/**
 * 银行卡模拟
 */
class BankCard {
    private static int money = 3000;//模拟账户余额
    public synchronized void getMoney(String name,int m){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(money > m){
            System.out.println(name+"取走了"+m+"元");
            money = money - m;
            System.out.println(money);
        }else{
            System.out.println("对不起，您的余额不足！");
        }
    }
}



