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
    private CheckBox cb_1, cb_2, cb_3, cb_4, cb_5, cb_6, cb_7, cb_8, cb_9, cb_10, cb_11, cb_12, cb_13, cb_14;

    public ArrayList<String> checked = new ArrayList<>();
    public ArrayList<Integer> checkList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recruit_category);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("SoftwarePBL-Team14");

        recruit_btn = findViewById(R.id.recruit_btn);
        cb_1 = findViewById(R.id.cb_1);
        cb_2 = findViewById(R.id.cb_2);
        cb_3 = findViewById(R.id.cb_3);
        cb_4 = findViewById(R.id.cb_4);
        cb_5 = findViewById(R.id.cb_5);
        cb_6 = findViewById(R.id.cb_6);
        cb_7 = findViewById(R.id.cb_7);
        cb_8 = findViewById(R.id.cb_8);
        cb_9 = findViewById(R.id.cb_9);
        cb_10 = findViewById(R.id.cb_10);
        cb_11 = findViewById(R.id.cb_11);
        cb_12 = findViewById(R.id.cb_12);
        cb_13 = findViewById(R.id.cb_13);
        cb_14 = findViewById(R.id.cb_14);

        recruit_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (cb_1.isChecked())
                {
                    checked.add(cb_1.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_2.isChecked())
                {
                    checked.add(cb_2.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_3.isChecked())
                {
                    checked.add(cb_3.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_4.isChecked())
                {
                    checked.add(cb_4.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_5.isChecked())
                {
                    checked.add(cb_5.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_6.isChecked())
                {
                    checked.add(cb_6.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_7.isChecked())
                {
                    checked.add(cb_7.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_8.isChecked())
                {
                    checked.add(cb_8.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_9.isChecked())
                {
                    checked.add(cb_9.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_10.isChecked())
                {
                    checked.add(cb_10.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_11.isChecked())
                {
                    checked.add(cb_11.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_12.isChecked())
                {
                    checked.add(cb_12.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_13.isChecked())
                {
                    checked.add(cb_13.getText().toString().trim());
                    checkList.add(1);
                }
                else
                {
                    checkList.add(0);
                }
                if (cb_14.isChecked())
                {
                    checked.add(cb_14.getText().toString().trim());
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