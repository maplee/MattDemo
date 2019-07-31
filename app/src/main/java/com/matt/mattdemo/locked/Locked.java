package com.matt.mattdemo.locked;

/**
 * Author:Created by jiaguofeng on 2019/7/17.
 * Email:jiaguofeng@inno72.com
 */
public class Locked {

    private void test(){
        synchronized (Locked.class){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test();
        }
    }
}
