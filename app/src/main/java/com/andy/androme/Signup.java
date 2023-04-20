package com.andy.androme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    EditText user1,pass1,repass;
    Button log,sign;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        user1 = findViewById(R.id.user);
        pass1 = findViewById(R.id.pass);
        repass = findViewById(R.id.conf_pass);
        log = findViewById(R.id.LoginBtn1);
        sign = findViewById(R.id.registerBtn);
        DB = new DBHelper(this);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = user1.getText().toString();
                String pass = pass1.getText().toString();
                String cpass = repass.getText().toString();

                if(TextUtils.isEmpty(user)||TextUtils.isEmpty(pass)||TextUtils.isEmpty(cpass)){
                    Toast.makeText(Signup.this, "All feilds are required", Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.equals(cpass)){
                        Boolean checkUser = DB.checkUsrename(user);
                        if(checkUser == false){
                            Boolean insert = DB.insertData(user,pass);
                            if(insert == true){
                                Toast.makeText(Signup.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(Signup.this, "Registeration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(Signup.this, "User already exists", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Signup.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}