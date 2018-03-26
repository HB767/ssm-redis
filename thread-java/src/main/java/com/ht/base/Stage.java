package com.ht.base;

import com.ht.base.ArmyRunnable;

//舞台
public class Stage extends Thread {
    @Override
    public void run() {

        ArmyRunnable aa = new ArmyRunnable();
        ArmyRunnable bb = new ArmyRunnable();

        //使用Runnable接口创建线程
        Thread aaa = new Thread(aa,"水军");
        Thread bbb = new Thread(bb,"农民起义军");

        //启动线程,让军队开始作战
        aaa.start();
        bbb.start();

        //舞台线程休眠，大家专心观看军队厮杀
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("半路杀出陈咬金。。。。");
        Thread ccc = new KeyPersonThread();
        ccc.setName("陈咬金");
        System.out.println("快点结束战争。。。");

        //停止线程
        aa.keepRunning = false;
        bb.keepRunning = false;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //咬金
        ccc.start();

        try {
            ccc.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Stage().start();
    }
}
