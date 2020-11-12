package com.nbpt.zyx_sb;

import android.app.Activity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main4Activity extends Activity {

        String Fruitname[] = {"苹果","香蕉","樱桃","葡萄","芒果","橘子","梨","菠萝","草莓","西瓜"};
    int image[]={R.drawable.apple_pic,R.drawable.banana_pic,
            R.drawable.cherry_pic,R.drawable.grape_pic,
            R.drawable.mango_pic,R.drawable.orange_pic,
            R.drawable.pear_pic,R.drawable.pineapple_pic,
            R.drawable.strawberry_pic,R.drawable.watermelon_pic};

        GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        GridView gridView = (GridView)findViewById(R.id.pl);

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
        SimpleAdapter adapter = new SimpleAdapter(Main4Activity.this,imageList,R.layout.gridview_item,from,to);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Main4Activity.this,"当前点击的水果是:"+Fruitname[i],Toast.LENGTH_LONG).show();
            }
        });


    }
}
