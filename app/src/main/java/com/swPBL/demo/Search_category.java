package com.swPBL.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Search_category extends AppCompatActivity
{
    private Button search_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_category);

        Intent intent = getIntent();

        search_btn = findViewById(R.id.search_btn);
        search_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Search_category.this , View_list.class);
                startActivity(intent);
            }
        });
    }
}