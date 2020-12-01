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

}
