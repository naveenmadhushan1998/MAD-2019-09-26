package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResetPWActivity extends AppCompatActivity {

    Button reset_btn;
    EditText mTextUsername;
    EditText mTextPassword;
    DatabaseHelper db;
    Button mButtonLogin;
    TextView mTextViewRegister;
    ViewGroup progressView;
    protected boolean isProgressShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pw);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        reset_btn = (Button)findViewById(R.id.reset_btn);

        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                Boolean res = db.checkUser(user, pwd);
                if(res == true)
                {
                    Intent HomePage = new Intent(ResetPWActivity.this,ResetActivity.class);
                    startActivity(HomePage);
                }
                else
                {
                    Toast.makeText(ResetPWActivity.this,"User name not found",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}