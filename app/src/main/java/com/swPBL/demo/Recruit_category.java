package com.swPBL.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;

public class Recruit_category extends AppCompatActivity
{
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;

    private Button recruit_btn;
    private CheckBox cb_lunch, cb_dinner, cb_midnight, cb_2p, cb_3p, cb_4p, cb_5p, cb_japanese, cb_western, cb_korean, cb_chinese, cb_flour, cb_fastfood, cb_meat, cb_etc;

    public ArrayList<String> checked;
    public ArrayList<Integer> checkList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recruit_category);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("SoftwarePBL-Team14");

        checked = new ArrayList<>();
        checkList = new ArrayList<>();

        recruit_btn = findViewById(R.id.recruit_btn);
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

        recruit_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (cb_lunch.isChecked())
                {
                    checked.add(cb_lunch.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_dinner.isChecked())
                {
                    checked.add(cb_dinner.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_midnight.isChecked())
                {
                    checked.add(cb_midnight.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_2p.isChecked())
                {
                    checked.add(cb_2p.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_3p.isChecked())
                {
                    checked.add(cb_3p.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_4p.isChecked())
                {
                    checked.add(cb_4p.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_5p.isChecked())
                {
                    checked.add(cb_5p.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_japanese.isChecked())
                {
                    checked.add(cb_japanese.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_western.isChecked())
                {
                    checked.add(cb_western.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_korean.isChecked())
                {
                    checked.add(cb_korean.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_chinese.isChecked())
                {
                    checked.add(cb_chinese.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_flour.isChecked())
                {
                    checked.add(cb_flour.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_fastfood.isChecked())
                {
                    checked.add(cb_fastfood.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_meat.isChecked())
                {
                    checked.add(cb_meat.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_etc.isChecked())
                {
                    checked.add(cb_etc.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                //카테고리 개수만큼 체크박스 개수 수정.

                Intent intent = new Intent(Recruit_category.this, MainActivity.class);
                startActivity(intent);

                FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).child("RecruitCategory").setValue(checked); // 체크된 정보(한글, 쉼표 없음)
                mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).child("RecruitCategory2").setValue(checkList);  // 0과 1로 표현된 정보
            }
        });
    }
}