package com.imooc.concurrent.train.ticket;

/**
 * Created by knight on 17/3/10.
 */
public class SaleTicketWindowTask implements Runnable {

    private  int ticketsCount =5;

    public void run() {
        synchronized (this){
            while (this.ticketsCount>0){
                System.out.println(Thread.currentThread().getName()+"卖出了一张票");
                this.ticketsCount --;
                System.out.println("剩余的票数为"+this.ticketsCount);
            }
        }

    }
}
