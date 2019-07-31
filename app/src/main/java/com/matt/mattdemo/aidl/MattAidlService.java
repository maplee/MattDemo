package com.matt.mattdemo.aidl;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.matt.mattdemo.IMattAidlInterface;
import com.matt.mattdemo.R;
import com.matt.mattdemo.SecondActivity;
import com.matt.mattdemo.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:Created by jiaguofeng on 2019/7/21.
 * Email:jiaguofeng@inno72.com
 */
public class MattAidlService extends Service {

    private NotificationManager mNotificationManager;
    private boolean mCanRun = true;
    private List<Student> mStudents = new ArrayList<Student>();


    private IMattAidlInterface.Stub mStub = new IMattAidlInterface.Stub() {
        @Override
        public void put(String param) throws RemoteException {

        }

        @Override
        public String get() throws RemoteException {
            return null;
        }

        @Override
        public Student getStudent() throws RemoteException {
            return null;
        }
    };


    @Override
    public void onCreate() {
        super.onCreate();
        Thread thr = new Thread(null, new ServiceWorker(), "BackgroundService");
        thr.start();

        synchronized (mStudents) {
            for (int i = 1; i < 6; i++) {
//                Student student = new Student();
//                student
//                student.age = i * 5;
//                mStudents.add(student);
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        displayNotificationMessage("服务已启动");

        return mStub;
    }

    private void displayNotificationMessage(String message)
    {
        Notification notification = new Notification(R.mipmap.ic_launcher, message,
                System.currentTimeMillis());
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        notification.defaults |= Notification.DEFAULT_ALL;
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, SecondActivity.class), 0);
        notification.contentIntent = contentIntent;
        notification.tickerText = "dihrg"+message;
//        notification.setLatestEventInfo(this, "我的通知", message,
//                contentIntent);
        mNotificationManager.notify(1234567, notification);
    }

    class ServiceWorker implements Runnable {
        long counter = 0;

        @Override
        public void run() {
            // do background processing here.....
            while (mCanRun) {
                Log.d("scott", "" + counter);
                counter++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
