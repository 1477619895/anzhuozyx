package com.nbpt.zyx_sb;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class Main4Activity extends Activity {

        String Fruitname[] = {"苹果","香蕉","樱桃","葡萄","芒果","橘子","梨","菠萝","草莓","西瓜"};
        GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        GridView gridView = (GridView)findViewById(R.id.pl);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,Fruitname);

        gridView.setAdapter(adapter);
    }
}
