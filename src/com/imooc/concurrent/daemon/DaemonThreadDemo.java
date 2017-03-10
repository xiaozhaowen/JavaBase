package com.imooc.concurrent.daemon;

/**
 * Created by knight on 17/3/10.
 */
public class DaemonThreadDemo extends  Thread {

    @Override
    public void run() {
        int count =0;
        while (count<30){
            System.out.println("log--"+count++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
