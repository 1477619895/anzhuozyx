package com.nbpt.zyx_sb;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends Activity {
    EditText yhText;
    EditText mmText;
    EditText mm;
    Button xs, qk, dl,tuichu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        yhText = findViewById(R.id.yhtext);
        //  yhText.setText("admin");

        mmText = findViewById(R.id.mmtext);
//      String mm= mmText.getText().toString();
        //     Log.d("TAG", "密码是："+mm);
        mm = findViewById(R.id.mm);
        xs = findViewById(R.id.xs);
       qk = findViewById(R.id.qk);
       dl=findViewById(R.id.dl);
       tuichu= findViewById(R.id.tuichu);
        View.OnClickListener  listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.xs:
                        mm.setText("你刚刚点击了显示按钮");
                        break;
                    case R.id.qk:
                        yhText.setText("");
                        mmText.setText("");
                        mm.setText("");
                        break;
                   case R.id.dl:
                        String username = yhText.getText().toString();
                        String password = mmText.getText().toString();
                        if((username.equals("admin"))&&(password.equals("4456"))) {
                            Toast.makeText(SecondActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(SecondActivity.this, "用户名或密码不对！", Toast.LENGTH_LONG).show();
                        }break;
                    case R.id.tuichu:finish();break;}
            }
        };
        xs.setOnClickListener(listener);
        qk.setOnClickListener(listener);
        dl.setOnClickListener(listener);
       tuichu.setOnClickListener(listener);
//        View.OnClickListener listener_display = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mm.setText("你刚刚点击了显示按钮");
//            }
//        };
//        View.OnClickListener listener_clear = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                yhText.setText("");
//                mmText.setText("");
//                mm.setText("");
//            }
//        };
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second);
//        mm = findViewById(R.id.mm);
//        xs = findViewById(R.id.xs);
//        xs.setOnClickListener(listener_display);
//        qk = findViewById(R.id.qk);
//        qk.setOnClickListener(listener_clear);


//        View.OnClickListener tuic = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        };
//        exit=findViewById(R.id.tuichu);
//        exit.setOnClickListener(tuic);
    }
//        View.OnClickListener denglu = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String username = yhText.getText().toString();
//                String password = mmText.getText().toString();
//                if((username.equals("admin"))&&(password.equals("4456"))) {
//                    Toast.makeText(SecondActivity.this, "登录成功", Toast.LENGTH_LONG).show();
//                }else{
//                    Toast.makeText(SecondActivity.this, "用户名或密码不对！", Toast.LENGTH_LONG).show();
//                }
//            }
//        };
//
//        dl=findViewById(R.id.dl);
//        dl.setOnClickListener(denglu);

//        public void Clickbt(View view){
//        String username = yhText.getText().toString();
//        String password = mmText.getText().toString();
//        if((username.equals("admin"))&&(password.equals("4456"))) {
//            Toast.makeText(SecondActivity.this, "登录成功", Toast.LENGTH_LONG).show();
//        }else{
//            Toast.makeText(SecondActivity.this, "用户名或密码不对！", Toast.LENGTH_LONG).show();
//        }
//    }
}


