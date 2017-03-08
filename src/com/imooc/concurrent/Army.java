package com.imooc.concurrent;

/**
 * Created by knight on 17/3/8.
 */
public class Army implements  Runnable{

    //volatile保证了线程可以正确的读取其他线程写入的值
    //可见性 ref JMM， happens-before原则
    volatile boolean keepRunning = true;
    public void run() {
        while (keepRunning){
            for (int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+ "攻击了对方["+i+"]");
                //让出处理器资源,下次调度器使用哪个线程不确定
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName()+" 结束了战斗");
    }
}
