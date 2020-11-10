package com.nbpt.zyx_sb;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RegisterActivity extends Activity {
    EditText yh,mm,zcmm;
    Button zc;
    private static final String TAG="RegisterActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        yh= findViewById(R.id.yh);
        mm=findViewById(R.id.mm);
        zcmm=findViewById(R.id.zcmm);

        zc=findViewById(R.id.zhuc);
        zc.setOnClickListener(zhuce);
    }
//    private  int REQUEST_CREATENEW = 0;
    View.OnClickListener zhuce = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String username = yh.getText().toString();
            String password1 = mm.getText().toString();
            String password22 = zcmm.getText().toString();
            if (username.isEmpty() || password1.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "用户名和密码不能为空!", Toast.LENGTH_LONG).show();
            } else if (!password1.equals(password22)) {
                Toast.makeText(RegisterActivity.this, "输入的密码不一样！!", Toast.LENGTH_LONG).show();
                mm.setText("");
                zcmm.setText("");
            } else {
                AccountDBHelper db = new AccountDBHelper(RegisterActivity.this, AccountDBHelper.VERSION_1);
                long ret = db.inserUser(username, password1, 1, null);
                Log.d(TAG, "ret = " + ret);
                if (ret == -1) {
                    Toast.makeText(RegisterActivity.this, "账号已注册！", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                    Intent data = new Intent();
                    data.putExtra("username", username);
                    data.putExtra("password", password1);
                    setResult(0, data);
                    finish();
                }

            }

//            finish();
        }
    };

}
