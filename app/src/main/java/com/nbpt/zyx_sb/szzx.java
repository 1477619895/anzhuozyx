package com.nbpt.zyx_sb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class szzx extends Activity {
    ListView qwe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_szzx);
        ListView listView = findViewById(R.id.qq);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:{Intent intent = new Intent(szzx.this, zhinengjiaju.class);
                        startActivity(intent);break;}
                    case 1:{Intent intent1 = new Intent(szzx.this, znsc.class);
                        startActivity(intent1);break;}
                    case 2:{Intent intent2 = new Intent(szzx.this, tqyb.class);
                        startActivity(intent2);break;}
                    case 3:{Intent intent3 = new Intent(szzx.this, lianxiwomen.class);
                        startActivity(intent3);break;}
                }
            }
        });



    }

}
