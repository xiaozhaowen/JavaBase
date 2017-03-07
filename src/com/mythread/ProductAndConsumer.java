package com.mythread;



/**
 * Created by knight on 17/3/7.
 */
public class ProductAndConsumer {
    public static void test(){
        Basket basket = new Basket();
        Product product = new Product(basket);
        Consumer consumer = new Consumer(basket);

        new Thread(product).start();
        new Thread(consumer).start();
    }
}

/**
 * 馒头类
 */
class ManTou {
    int id;

    public ManTou(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ManTou" + id;
    }
}

/**
 * 篮子类
 */
class Basket {
    int index = 0; //栈顶指针
    ManTou[] manTous = new ManTou[6];

    /**
     * 往篮子里放馒头,如果放满了则处于等待状态
     *
     * @param manTou
     */
    public synchronized void push(ManTou manTou) {
        while (index == manTous.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        manTous[index] = manTou;
        index++;
    }

    /**
     * 从篮子里取馒头,如果篮子里馒头空了,则处于等待状态
     *
     * @return
     */
    public synchronized ManTou pop() {
        while (index == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        index--;
        return manTous[index];
    }
}

/**
 * 生产者
 */
class Product implements Runnable {
    Basket basket;

    public Product(Basket basket) {
        this.basket = basket;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            ManTou m = new ManTou(i);
            basket.push(m);
            System.out.println("生产了" + m);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable {
    Basket basket;

    public Consumer(Basket basket) {
        this.basket = basket;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            ManTou m = basket.pop();
            System.out.println("消费了" + m);
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



