package com.imooc.concurrent.transform;

/**
 * Created by knight on 17/3/9.
 */
public class EnergyClient {

    //将要构建的能量世界中的盒子数量
    static final int  BOX_LENGTH=100;

    //每个盒子的初始能量
    static final double  BOX_INIT_ENERGY=1000.0;

    public static void  test(){
        //能量世界
        EnergySystem energySystem = new EnergySystem(BOX_LENGTH,BOX_INIT_ENERGY);

        //创建100个线程,每个线程驱动一个任务
        for (int i = 0; i < BOX_LENGTH; i++) {
            TransferTask transferTask = new TransferTask(energySystem,i,BOX_INIT_ENERGY);
            Thread thread = new Thread(transferTask,"Thread--"+i);
            thread.start();
        }
    }
}
