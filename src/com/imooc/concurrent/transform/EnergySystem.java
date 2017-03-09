package com.imooc.concurrent.transform;

/**
 * Created by knight on 17/3/9.
 *
 * 能量世界
 * 能量需要守恒,能量不会凭空产生,也不会凭空消失,只会从一处转移到另一处
 *
 */


public class EnergySystem {

    //能量盒子数组,能量存储的地方
    private final double [] energyBoxes;
    private final Object lockObj = new Object();

    /**
     * 能量盒子构造函数
     * @param boxLength 能量盒子的数量
     * @param initEnergy 每个能力盒子初始化的能量值
     */
    public EnergySystem(int boxLength,double initEnergy) {
        this.energyBoxes = new double[boxLength];
        for(int i=0;i<boxLength;i++){
            this.energyBoxes[i] = initEnergy;
        }
    }


    /**
     * 能量的转移,从一个盒子到另一个盒子
     * @param fromIndex 移动源头索引
     * @param toIndex 移动终点索引
     * @param amount 能量值
     */
    public void transfer(int fromIndex,int toIndex,double amount){
        synchronized (lockObj){
            if(this.energyBoxes[fromIndex] < amount){
//                System.out.println("源能量不足以传输移动值");
                return;
            }
            /**
             * 循环的作用是,保证条件不满足时任务都会被条件阻挡,而不是去继续竞争CPU资源
             */
            while (this.energyBoxes[fromIndex] < amount){
                try {
                    lockObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.print(Thread.currentThread().getName());
            energyBoxes[fromIndex] -= amount;
            System.out.printf("从%d转移%10.2f单位能量到%d", fromIndex, amount, toIndex);
            energyBoxes[toIndex] += amount;
            System.out.printf(" 能量总和：%10.2f%n", getTotalEnergy());
            //唤醒所有的lockObj对象上的等待线程
            lockObj.notifyAll();
        }
    }

    /**
     * 获取能量的总和
     * @return 能量值的总和
     */
    private double getTotalEnergy(){
        double total =0.0;
        for (int i = 0; i < this.energyBoxes.length; i++) {
            total += this.energyBoxes[i];
        }
        return  total;
    }

    /**
     * 得到能量盒子的长度
     * @return
     */
    public int  getBoxLength(){
        return  this.energyBoxes.length;
    }
}
