package com.swPBL.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

<<<<<<< HEAD
    private Button recruit_btn;
    private Button search_btn;
=======
    private Button btn_1;
    private Button btn_2;
>>>>>>> 12cae84d21cbca9deba033d7160bd0587478fd5d

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_login);

        recruit_btn = findViewById(R.id.recruit_btn);
        recruit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , Recruit_category.class);
=======
        setContentView(R.layout.activity_main);

        btn_1 = findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , SecondActivity.class);
>>>>>>> 12cae84d21cbca9deba033d7160bd0587478fd5d
                startActivity(intent);
            }
        });

<<<<<<< HEAD
        search_btn = findViewById(R.id.search_btn);
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , Search_category.class);
=======
        btn_2 = findViewById(R.id.btn_2);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , ThirdActivity.class);
>>>>>>> 12cae84d21cbca9deba033d7160bd0587478fd5d
                startActivity(intent);
            }
        });
    }
}