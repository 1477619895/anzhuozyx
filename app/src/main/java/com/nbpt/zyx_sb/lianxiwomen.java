package com.nbpt.zyx_sb;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
}
