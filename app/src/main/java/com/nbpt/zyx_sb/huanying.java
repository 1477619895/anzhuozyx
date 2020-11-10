package com.nbpt.zyx_sb;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;
public class huanying extends Activity {
    private TextView tvskip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huanying);
        tvskip=findViewById(R.id.tv);
        tvskip.setOnClickListener(dianji);
        countDownTimer.start();
    }
View.OnClickListener dianji = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        tvskip.setText("正在跳转");
        Intent intent1=new Intent(huanying.this,Linear.class);
        startActivity(intent1);
    }
};

//    public void onSkipClick(View view){
//
//        Intent intent1=new Intent(huanying.this,Linear.class);
//        startActivity(intent1);
////        if (countDownTimer != null)
////        {
////            countDownTimer.cancel();
////            Intent intent1=new Intent(huanying.this,Linear.class);
////            startActivity(intent1);
////        }
//    }

    CountDownTimer countDownTimer = new CountDownTimer(3000,1000) {

        @Override
        public void onTick(long l) {tvskip.setText(getString(R.string.skip_wait,(l/1000)));}

        @Override
        public void onFinish() {
            tvskip.setText("正在跳转");
            Intent intent1=new Intent(huanying.this,Linear.class);
            startActivity(intent1);
        }
    };
}

