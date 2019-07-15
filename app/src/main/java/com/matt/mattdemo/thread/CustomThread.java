package com.matt.mattdemo.thread;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Author:Created by jiaguofeng on 2019/7/11.
 * Email:jiaguofeng@inno72.com
 */
public class CustomThread extends Thread {

    private AtomicBoolean flag = new AtomicBoolean(false);

    @Override
    public void run() {

        int i = 0;
        try {
            while (i<8) {
                i++;
//                Thread.sleep(1000);
                System.out.println("run :"+i);
//                System.out.println("runing");
//                System.out.println("run over");

//                if(this.isInterrupted()){
//                    break;
//                }

                if(flag.get()){
                    synchronized (this){
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            System.out.println("run ------------->>>>over");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean getFlag() {
        return flag.get();
    }

    public void setFlag(boolean flag) {
        this.flag.set(flag);
    }
}
