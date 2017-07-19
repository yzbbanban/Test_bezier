package com.bb.yzbbanban.test_aidl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    BezierView bezierView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bezierView=new BezierView(this);


    }



}
