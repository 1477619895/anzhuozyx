package com.nbpt.zyx_sb;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Linear extends Activity {
    EditText yhText;
    EditText mmText;
    Button login;
    Button zc;
    private int count=0;
    private CheckBox checkBox,checkBox1;
    private SharedPreferences sp,sp_1;
    boolean isCheck = false,isAuto=false;
    private CheckBox auto;
    private String sUsername,sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        yhText = findViewById(R.id.yh);
        mmText = findViewById(R.id.mm);
        login = findViewById(R.id.login);

        checkBox = (CheckBox) findViewById(R.id.box);
        checkBox.setOnCheckedChangeListener(chkbox);

        checkBox1 = (CheckBox) findViewById(R.id.zd);
        checkBox1.setOnCheckedChangeListener(listener_check);

        sp = Linear.this.getSharedPreferences("user_info", MODE_PRIVATE);
        sp_1 = Linear.this.getSharedPreferences("out_info", MODE_PRIVATE);
        sUsername = sp.getString("username", "");
        sPassword = sp.getString("password", "");
        if (sp.getBoolean("isCheck", false)) {
            yhText.setText(sUsername);
            mmText.setText(sPassword);
            checkBox.setChecked(true);
//            finish();
        }
            if (sp_1.getBoolean("isAuto", false)) {
                checkBox1.setChecked(true);
                    Intent intent = new Intent(Linear.this, MenuActivity.class);
                    startActivity(intent);


        }
    }
    CompoundButton.OnCheckedChangeListener chkbox = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            isCheck = b;
            Toast.makeText(Linear.this,"点击记住密码!",Toast.LENGTH_SHORT).show();
        }
    };

    CompoundButton.OnCheckedChangeListener listener_check=new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            sp_1.edit().putBoolean("isAuto", b).commit();
            isAuto = b;
        }
    };


//    public void  liner(View view){
//        Intent intent=new Intent(Linear.this,RegisterActivity.class);
//        startActivity(intent);
//    }


        public void clickLogin(View view) {
            String username = yhText.getText().toString();
            String password = mmText.getText().toString();
            if ((!username.isEmpty()) && (!password.isEmpty())) {
                AccountDBHelper db = new AccountDBHelper(Linear.this, AccountDBHelper.VERSION_1);
                Cursor cursor = db.select(null, null);
                if (cursor.getCount() != 0) {
                    cursor.moveToFirst();
                    do {
                        if (username.equals(db.getUsername(cursor))) {
                            if (password.equals(db.getPassword(cursor))) {
                           Toast.makeText(Linear.this, "登录成功", Toast.LENGTH_LONG).show();
                                if (isCheck) {
                                    SharedPreferences.Editor editor = sp.edit();
                                    editor.putString("username", username);
                                    editor.putString("password", password);
                                    editor.putBoolean("isCheck", isCheck);
                                    editor.commit();
                                } else {
                                    SharedPreferences.Editor editor = sp.edit();
                                    editor.clear();
                                }
                                Intent intent = new Intent(Linear.this, MenuActivity.class);
                                startActivity(intent);
                            } else if (password.equals(db.getPassword(cursor))) {
                                Toast.makeText(Linear.this, "密码错误", Toast.LENGTH_LONG).show();
                            }
                            count = 1;
                        }
                    } while (cursor.moveToNext());
//                    if (count == 0) {
//                        Toast.makeText(Linear.this, "账号未注册", Toast.LENGTH_LONG).show();
//                    }
                    cursor.close();
                }
            } else if ((username.isEmpty()) && (!password.isEmpty()))
                Toast.makeText(Linear.this, "账号为空", Toast.LENGTH_LONG).show();
            else if ((!username.isEmpty()) && (password.isEmpty()))
                Toast.makeText(Linear.this, "密码为空", Toast.LENGTH_LONG).show();
            else if ((username.isEmpty()) && (password.isEmpty()))
                Toast.makeText(Linear.this, "账号密码为空", Toast.LENGTH_LONG).show();


        }
    public void zhuce(View view){
        Intent intent1=new Intent(Linear.this,RegisterActivity.class);
        startActivity(intent1);
    }
    @Override
    protected void onStop() {
        super.onStop();
       finish();
    }
}
