package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.RestrictionEntry;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResetActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        db = new DatabaseHelper(this);

        mTextPassword = (EditText)findViewById(R.id.question_1);
        mTextCnfPassword = (EditText)findViewById(R.id.question_2);
        mButtonRegister = (Button)findViewById(R.id.verify_btn);

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextCnfPassword.getText().toString().trim();

                if(pwd.equals(cnf_pwd)){
                    long val = db.updateUser(pwd);
                    if(val > 0){
                        Toast.makeText(ResetActivity.this,"You have Updated",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(ResetActivity.this, MainActivity.class);
                        startActivity(moveToLogin);
                    }
                    else{
                        Toast.makeText(ResetActivity.this,"Reset Error",Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(ResetActivity.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
