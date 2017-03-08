package com.imooc.concurrent;

/**
 * Created by knight on 17/3/8.
 */
public class Hero extends Thread {

    @Override
    public void run() {
        System.out.println("英雄 "+getName() + "开始了战斗");
        for(int i=0;i<10;i++){
            System.out.println("英雄"+getName()+"左突右杀,攻击隋军...");
        }
        System.out.println(getName() +" 结束了战斗 ");
    }
}
