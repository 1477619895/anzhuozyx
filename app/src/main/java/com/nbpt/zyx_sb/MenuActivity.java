package com.nbpt.zyx_sb;

import android.app.Activity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuActivity extends Activity {

    String Fruitname[] = {"智能家居","智能商超","天气预报","设置中心"};
    int image[]={R.drawable.icon_home,R.drawable.icon_shopping,
            R.drawable.icon_weather,R.drawable.icon_settings};

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        GridView gridView = (GridView)findViewById(R.id.q);

        String[] from = {"img","name"};
        int[] to = {R.id.imageView,R.id.textView2};
        List<Map<String,Object>> imageList = new ArrayList<Map<String,Object>>();
        for (int i=0;i<image.length;i++){
            Map<String,Object> map = new ArrayMap<String,Object>();
            map.put("img",image[i]);
            map.put("name",Fruitname[i]);
            imageList.add(map);
        }

//        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,Fruitname);
        SimpleAdapter adapter = new SimpleAdapter(MenuActivity.this,imageList,R.layout.gridview_item,from,to);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MenuActivity.this,"当前点击的图标是:"+Fruitname[i],Toast.LENGTH_LONG).show();
            }
        });
    }
}
