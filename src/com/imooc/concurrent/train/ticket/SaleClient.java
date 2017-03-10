package com.imooc.concurrent.train.ticket;

/**
 * Created by knight on 17/3/10.
 */
public class SaleClient {
    public static void test(){
        SaleTicketWindowTask task = new SaleTicketWindowTask();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(task,"Thread--"+i);
            thread.start();
        }
    }
}
