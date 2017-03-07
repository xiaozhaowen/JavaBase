package com.mythread;

/**
 * Created by knight on 17/3/7.
 */
public class DeadLock implements Runnable{

    int flag =1;
    static Object o1 = new Object();
    static Object o2 = new Object();
    public void run() {
        System.out.println(flag);

        if(flag ==1){
            synchronized (o1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("1");
                }
            }
        }

        if(flag ==0){
            synchronized (o2){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("0");
                }
            }
        }
    }

    public static void  test(){
        DeadLock t1 = new DeadLock();
        DeadLock t2 = new DeadLock();
        t1.flag =1;
        t2.flag =0;
        new Thread(t1).start();
        new Thread(t2).start();
    }
}


