package com.mythread;

import org.junit.Test;

import java.util.Date;

/**
 * Created by knight on 17/3/7.
 *
 *
 * 1.一般业务处理类去实现runnable接口,然后开启一个线程去执行。
 *
 * 2.主线程可以通过interrupt方法或者stop方法停止掉,但是这样有一个坏处就是:
 * 如果子线程稍微处理完毕,也就是run方法没有执行完毕这个时候可能会导致资源不能释放
 *
 * 3.join方法:一直执行某个线程到结束,然后才开始执行其他线程
 * 4.yield : 暂停调用此方法的线程,然后去执行其他的线程
 *
 *
 *
 */
public class Stratup {

    int num =10;

    @Test
    public void testRunnable(){
        Runnable1 r = new Runnable1();
        Thread thread = new Thread(r);      //创建线程
        thread.start();                     //启动线程
        int myNum=122;
        System.out.println(myNum);

        for (int i=0;i<100;i++){
            System.out.println("Main:" +i);
        }
    }

    @Test
    public void testExtends(){
        MyTestThread t = new MyTestThread();    //创建线程
        t.start();                              //启动线程
        for (int i=0;i<100;i++){
            System.out.println("Main:"+i);
        }
    }

    @Test
    public void testSleep(){
        SleepThread sleepThread = new SleepThread();sleepThread.interrupt();
        sleepThread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sleepThread.flag = false;
    }

    @Test
    public void testJoin(){
        Thread t = new JoinThread("joinTest");
        t.start();

        for (int i=0;i<20;i++){
            System.out.println("我是主线程");
            if(i==10){
                try {
                    t.join();           //join方法之后就必须等待t线程执行结束之后才会去执行其他线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void yieldTest(){
        YieldThread t1 = new YieldThread("t1");
        YieldThread t2 = new YieldThread("t2");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());

        t1.start();
        t2.start();
    }

}


class Runnable1 implements Runnable{

    public void run() {
        for (int i=0;i<100;i++){
            System.out.println("Thread ---:" +i);
        }
    }
}


/**
 * 这种方式不建议使用
 */
class MyTestThread extends Thread{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println("Sub Thread----"+i);
        }
    }
}

class SleepThread extends  Thread{
     boolean flag = true;

    @Override
    public void run() {
        while (flag){
            System.out.println("-----" + new Date() +"-----");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class JoinThread extends Thread{

     JoinThread(String name){
        super(name);
    }

    /**
     * getName() 方法获取线程的名称
     */
    @Override
    public void run() {
        for (int i=0;i<20;i++){
            System.out.println("我是" + getName() +"线程");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class YieldThread extends Thread{
    public YieldThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("我是"+getName() +"线程");
            if(i%10==0){
                yield(); //这个方法会暂停当前的线程并且执行其他的线程
            }
        }
    }
}