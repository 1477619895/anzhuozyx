package com.nbpt.zyx_sb;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.nbpt.smarthomelibrary.*;

public class lianxiwomen extends Activity {
    TextView dh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lianxiwomen);

        TextView dhhm = findViewById(R.id.dh);
        dhhm.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        TextView wangzhan = findViewById(R.id.WZ);
        wangzhan.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        Thread threadA = new Thread(new MyRunnable());
        threadA.start();

        MyThread threadB = new MyThread();
        threadB.start();
        SmartHub hub = new SmartHub();
        float temp = hub.getRoomTemperature();
    }


        public void qwe (View view)
        {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            Uri data =Uri.parse("tel:13505741234");
            intent.setData(data);
            startActivity(intent);

        }
    public void qwer (View view)
    {
        Uri uri = Uri.parse("http://www.baidu.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }
    public void qwerr (View view)
    {
        Uri data1 = Uri.parse("androidamap://viewMap?sourceApplication=appName&poiname=宁波职业技术学院&lat=29.90173&lon=121.820869&dev=0");
        Intent intent = new Intent(Intent.ACTION_VIEW, data1);
        startActivity(intent);

    }
    public class MyRunnable implements Runnable{
        @Override
        public void run(){
            while (true){
                Log.d("Thread","ThreadA正在运行");
                SystemClock.sleep(1000);

            }
        }
    }

    public class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            while (true){
                Log.d("Thread","ThreadB正在运行");
                SystemClock.sleep(1000);
            }
        }
    }

}
