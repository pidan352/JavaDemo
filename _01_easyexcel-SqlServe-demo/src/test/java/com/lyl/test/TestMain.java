package com.lyl.test;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2023/6/5 0005
 */

public class TestMain {

    public static void main(String[] args) throws InterruptedException {
        MyRunnable firstThread = new MyRunnable();
        Thread t1 = new Thread(firstThread);
        t1.start();

        Thread.sleep(200);

        firstThread.flag = false;
    }
}

class MyRunnable extends Thread {
    public boolean flag = true;

    @Override
    public void run() {

        while (flag) {

        }
    }
}