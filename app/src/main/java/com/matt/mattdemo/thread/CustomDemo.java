package com.matt.mattdemo.thread;

/**
 * Author:Created by jiaguofeng on 2019/7/11.
 * Email:jiaguofeng@inno72.com
 */
public class CustomDemo {

    private static final String TAG = "CustomDemo";

    public static void main(String...args){
        System.out.println("main start");

        CustomThread customThread = new CustomThread();
        customThread.start();
        customThread.interrupt();
//        synchronized (customThread){
//            try {
//                customThread.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        customThread.setFlag(true);
//        try {
//                customThread.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        System.out.println("-------------");
        System.out.println("main over");

    }
}
