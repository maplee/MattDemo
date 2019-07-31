package com.matt.mattdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.matt.one.MessageEvent;
import com.matt.two.ChildTwoActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button mainBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (BuildConfig.DEBUG) {
            Log.i(TAG, "onCreate: ");
        }
        mainBtn = (Button) findViewById(R.id.main_btn);
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SecondActivity.class));
            }
        });
        findViewById(R.id.childone_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ChildTwoActivity.class));
            }
        });
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        mainBtn.measure(w, h);
        //获得宽高
        int viewWidth=mainBtn.getMeasuredWidth();
        int viewHeight=mainBtn.getMeasuredHeight();
        if (BuildConfig.DEBUG) {
            Log.i(TAG, "onCreate: "+viewWidth+","+viewHeight);
            Log.i(TAG, "onCreate: "+getCallingActivity().toString());
        }



    }

    @Override
    protected void onStart() {
        super.onStart();
        if (BuildConfig.DEBUG) {
            Log.i(TAG, "onStart: ");
        }
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (BuildConfig.DEBUG) {
            Log.i(TAG, "onResume: ");
        }
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (BuildConfig.DEBUG) {
                    Log.i(TAG, "run: 8");
                }
            }
        },8000);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (BuildConfig.DEBUG) {
                    Log.i(TAG, "run: 3");
                }
            }
        },3000);
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (BuildConfig.DEBUG) {
                    Log.i(TAG, "run: 1");
                }
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (BuildConfig.DEBUG) {
            Log.i(TAG, "onRestart: ");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (BuildConfig.DEBUG) {
            Log.i(TAG, "onPause: ");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (BuildConfig.DEBUG) {
            Log.i(TAG, "onStop: ");
        }
        EventBus.getDefault().post(new MessageEvent(6,"main data"));
//        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (BuildConfig.DEBUG) {
            Log.i(TAG, "onDestroy: ");
        }
    }

    private void set(){
        synchronized (this){
            if (BuildConfig.DEBUG) {
                Log.i(TAG, "set: "+System.currentTimeMillis());
            }
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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

    private Handler mHandler = new Handler(){
        @Override
        public void dispatchMessage(Message msg) {
            super.dispatchMessage(msg);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
}
