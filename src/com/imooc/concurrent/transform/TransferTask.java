package com.imooc.concurrent.transform;

/**
 * Created by knight on 17/3/9.
 */
public class TransferTask implements Runnable {


    //共享的能量世界
    private EnergySystem energySystem;

    //能量转移的源能量盒子下标
    private int fromIndex = 0;

    //单次传递能量的最大单元
    private double maxAmount = 0.0;

    //最大休眠时间(毫秒)
    private int DELAY = 10;

    public TransferTask(EnergySystem energySystem, int fromIndex, double maxAmount) {
        this.fromIndex = fromIndex;
        this.maxAmount = maxAmount;
        this.energySystem = energySystem;
    }

    public void run() {
        try {
            while (true) {
                int toIndex = (int) (energySystem.getBoxLength() * Math.random());
                double amount = maxAmount * Math.random();
                this.energySystem.transfer(fromIndex, toIndex, amount);
                Thread.sleep((int) (DELAY * Math.random()));
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
