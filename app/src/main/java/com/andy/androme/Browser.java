package com.andy.androme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Browser extends AppCompatActivity {
    EditText search;
    Button btn12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        search = findViewById(R.id.Search);
        btn12 = findViewById(R.id.button12);

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String data = search.getText().toString();
                Intent intent = new Intent(getApplicationContext(),Loading.class);
                intent.putExtra("andy",data);
                startActivity(intent);
            }
        });
    }
}