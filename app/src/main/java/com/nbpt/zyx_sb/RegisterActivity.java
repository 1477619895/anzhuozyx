package com.nbpt.zyx_sb;

import android.app.Activity;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {
    EditText yh,mm;
    Button zc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        yh= findViewById(R.id.yh);
        mm=findViewById(R.id.mm);
        zc=findViewById(R.id.zhuc);
        zc.setOnClickListener(zhuce);
    }

    View.OnClickListener zhuce = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String username = yh.getText().toString();
            String password1 = mm.getText().toString();
            if(username.isEmpty() || password1.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "用户名和密码不能为空!", Toast.LENGTH_LONG).show();
            }else{
                    AccountDBHelper db= new AccountDBHelper(RegisterActivity.this,AccountDBHelper.VERSION_1);
                long  ret = db.inserUser(username,password1,1,null);
                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                }
        }
    };
}
