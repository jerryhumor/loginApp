package com.hdu.chenpengfei.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private Button registerBtn, loginBtn;
    private String schoolNumber, password;
    private EditText editSchoolNumber, editPassword;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        registerBtn = (Button) findViewById(R.id.login_btn_register);
        loginBtn = (Button) findViewById(R.id.login_btn_login);
        editSchoolNumber = (EditText) findViewById(R.id.login_edit_school_number);
        editPassword = (EditText) findViewById(R.id.login_edit_password);
        toolbar = (Toolbar) findViewById(R.id.login_toolbar);
        setSupportActionBar(toolbar);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                schoolNumber = editSchoolNumber.getText().toString();
                password = editPassword.getText().toString();
                int size = DataSupport.where("schoolNumber = ? and password = ?", schoolNumber, password).find(Student.class).size();
                if (size == 0)
                    Toast.makeText(LoginActivity.this, "没有此用户", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent, 0);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode){
            case RESULT_OK :Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                break;
            default:break;
        }
    }
}
