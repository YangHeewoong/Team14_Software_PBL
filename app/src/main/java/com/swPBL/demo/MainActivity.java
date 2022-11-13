package com.swPBL.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button recruit_btn;
    private Button search_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recruit_btn = findViewById(R.id.recruit_btn);
        recruit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , Recruit_category.class);
                startActivity(intent);
            }
        });

        search_btn = findViewById(R.id.search_btn);
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , Search_category.class);
                startActivity(intent);
            }
        });
    }
}