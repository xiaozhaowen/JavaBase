package com.mythread;

/**
 * Created by xiaozhao on 2017/3/7.
 */
public class LiftOff {
    public static void test(){
        Thread t  = new Thread(new CountDownLiff());
        t.start();
        System.out.println("等待火箭升空");
    }
}

class  CountDownLiff implements Runnable{
    protected int countDown =10;
    private static int taskCount =0;
    private final  int id =taskCount++;
    public CountDownLiff(){}
    public CountDownLiff(int countDown){
        this.countDown = countDown;
    }

    public String status(){
        return "#"+id +"("+
                (countDown>0 ? countDown : "Liftoff!") +"), ";
    }

    public void run() {
        while (countDown-->0){
            System.out.println(status());
            Thread.yield();
        }
    }
}