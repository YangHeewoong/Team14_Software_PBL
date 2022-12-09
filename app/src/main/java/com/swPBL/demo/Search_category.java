package com.swPBL.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Search_category extends AppCompatActivity
{
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    private ChildEventListener mChild;

    private Button search_btn;
    private CheckBox cb_lunch, cb_dinner, cb_midnight, cb_2p, cb_3p, cb_4p, cb_5p, cb_japanese, cb_western, cb_korean, cb_chinese, cb_flour, cb_fastfood, cb_meat, cb_etc;
    private int count, similar;
    private TextView tv_category;

    public ArrayList<Integer> checkList;
    public ArrayList<Integer> recruitList;
    public ArrayList<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_category);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("SoftwarePBL-Team14");

        checkList = new ArrayList<>();
        titleList = new ArrayList<>();
        recruitList = new ArrayList<>();

        count = 0;

        search_btn = findViewById(R.id.search_btn);
        cb_lunch = findViewById(R.id.cb_lunch);
        cb_dinner = findViewById(R.id.cb_dinner);
        cb_midnight = findViewById(R.id.cb_midnight);
        cb_2p = findViewById(R.id.cb_2p);
        cb_3p = findViewById(R.id.cb_3p);
        cb_4p = findViewById(R.id.cb_4p);
        cb_5p = findViewById(R.id.cb_5p);
        cb_japanese = findViewById(R.id.cb_japanese);
        cb_western = findViewById(R.id.cb_western);
        cb_korean = findViewById(R.id.cb_korean);
        cb_chinese = findViewById(R.id.cb_chinese);
        cb_flour = findViewById(R.id.cb_flour);
        cb_fastfood = findViewById(R.id.cb_fastfood);
        cb_meat = findViewById(R.id.cb_meat);
        cb_etc = findViewById(R.id.cb_etc);
        tv_category = findViewById(R.id.tv_category);

        search_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                checkList.clear();
                if (cb_lunch.isChecked())
                {
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_dinner.isChecked())
                {
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_midnight.isChecked())
                {
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_2p.isChecked())
                {
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_3p.isChecked())
                {
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_4p.isChecked())
                {
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_5p.isChecked())
                {
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_japanese.isChecked())
                {
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_western.isChecked())
                {
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_korean.isChecked())
                {
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_chinese.isChecked())
                {
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_flour.isChecked())
                {
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_fastfood.isChecked())
                {
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_meat.isChecked())
                {
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_etc.isChecked())
                {
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                //카테고리 개수만큼 체크박스 개수 수정.

                Intent intent = new Intent(Search_category.this, View_list.class);
                startActivity(intent);
            }
        });
    }
}