package com.imooc.concurrent;

/**
 * Created by knight on 17/3/8.
 *
 */


/**
 * 男演员类
 */
public class Actor extends  Thread {

    /**
     * 这是一个任务
     */
    @Override
    public void run() {
        System.out.println(getName() +":是一个男演员");
        int count =0;
        boolean keepRunning = true;

        while (keepRunning){
            System.out.println(getName()+"登台演出:" + (++count));
            if(count ==100){
                keepRunning = false;
            }

            if(count %10 ==0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println( getName() + ":演出结束了");
    }


    public static void test(){
        Thread actor = new Actor();
        actor.setName("刘德华");
        actor.start();

        Thread thread = new Thread(new Actress(),"梅艳芳");
        thread.start();
    }

}


class Actress implements Runnable{

    /**
     * 这是一个任务
     */
    public void run() {
        System.out.println(Thread.currentThread().getName()+ ":是一个女演员");
        int count =0;
        boolean keepRunning = true;
        while (keepRunning){
            System.out.println(Thread.currentThread().getName() +":在表演" +(++count));
            if(count ==100)
                keepRunning = false;

            if(count %10 ==0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println( Thread.currentThread().getName()+":表演结束了");
    }
}
