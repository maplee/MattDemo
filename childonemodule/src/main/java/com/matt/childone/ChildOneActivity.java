package com.matt.childone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ChildOneActivity extends AppCompatActivity {

    private static final String TAG = "ChildOneActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_one);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    public void click(View view){
        if(view.getId() == R.id.btn_childone_one){
            EventBus.getDefault().post(new MessageEvent(1,"childone"));
        }
        else if(view.getId() == R.id.btn_childone_two){
            EventBus.getDefault().post(new MessageEvent(2,"childone"));
        }
        else if(view.getId() == R.id.btn_childone_three){
            EventBus.getDefault().post(new MessageEvent(3,"childone"));
        }
        else if(view.getId() == R.id.btn_childone_four){
            EventBus.getDefault().post(new MessageEvent(4,"childone"));
        }
        else if(view.getId() == R.id.btn_childone_five){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    EventBus.getDefault().post(new MessageEvent(5,"childone"));
                }
            }).start();

        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        if(event == null){
            return;
        }

        Log.i(TAG, "onMessageEvent: "+event.toString());
        switch (event.getMsgId()){
            case 1:

                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onMessageBackEvent(MessageEvent event) {
        if(event == null){
            return;
        }

        Log.i(TAG, "onMessageBackEvent: "+event.toString());

    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onMessagePostingEvent(MessageEvent event) {
        if(event == null){
            return;
        }

        Log.i(TAG, "onMessagePostingEvent: "+event.toString());
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onMessageAsyncEvent(MessageEvent event) {
        if(event == null){
            return;
        }

        Log.i(TAG, "onMessageAsyncEvent: "+event.toString());
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    public void onMessageMainOrderedEvent(MessageEvent event) {
        if(event == null){
            return;
        }

        Log.i(TAG, "onMessageMainOrderedEvent: "+event.toString());
    }
}
