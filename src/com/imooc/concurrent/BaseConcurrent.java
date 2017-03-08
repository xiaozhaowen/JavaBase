package com.imooc.concurrent;

/**
 * Created by knight on 17/3/8.
 */
public class BaseConcurrent {
//    public static void testPerformance() {
//        Actor actor = new Actor();
//        actor.setName("梅兰芳");
//        actor.start();
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("舞台要闭幕下班了");
//
//        actor.keepRunning = false;
//    }
}

/*class Actor extends Thread{
    volatile boolean keepRunning = true;
    static  int count =0;

    @Override
    public void run() {
        System.out.println(getName()+"  开始表演");
        while (keepRunning){
            System.out.println(getName() +" 正在表演"+count++);
            if(count%10==0){
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
        System.out.println(getName()+"  表演结束");

    }
}


class MsActor implements Runnable{

    public void run() {

    }
}*/

