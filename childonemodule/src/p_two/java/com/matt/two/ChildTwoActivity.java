package com.matt.two;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.matt.one.ChildOneActivity;
import com.matt.one.R;

public class ChildTwoActivity extends AppCompatActivity {

    private static final String TAG = "ChildOneActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_two);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void click(View view){
        if(view.getId() == R.id.btn_activity_child_two_one){
            startActivity(new Intent(getApplicationContext(), ChildOneActivity.class));
        }

    }


}
