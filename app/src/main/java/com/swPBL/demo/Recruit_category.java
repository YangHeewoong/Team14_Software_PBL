package com.swPBL.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;

public class Recruit_category extends AppCompatActivity
{
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;

    private Button recruit_btn;
    private CheckBox cb_lunch, cb_dinner, cb_midnight, cb_2p, cb_3p, cb_4p, cb_5p, cb_japanese, cb_western, cb_korean, cb_chinese, cb_flour, cb_fastfood, cb_meat, cb_etc;
    private EditText et_roomname;

    public String sChecked;
    public ArrayList<Integer> iChecked;
    public ArrayList<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recruit_category);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("SoftwarePBL-Team14");

        iChecked = new ArrayList<>();
        titleList = new ArrayList<>();

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
        et_roomname = findViewById(R.id.et_roomname);

        recruit_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                sChecked = "";
                iChecked.clear();
                if (cb_lunch.isChecked())
                {
                    sChecked += cb_lunch.getText().toString().trim();
                    sChecked += "/";
                    iChecked.add(1);
                }
                else
                {
                    iChecked.add(0);
                }
                if (cb_dinner.isChecked())
                {
                    sChecked += cb_dinner.getText().toString().trim();
                    sChecked += "/";
                    iChecked.add(1);
                }
                else
                {
                    iChecked.add(0);
                }
                if (cb_midnight.isChecked())
                {
                    sChecked += cb_midnight.getText().toString().trim();
                    sChecked += "/";
                    iChecked.add(1);
                }
                else
                {
                    iChecked.add(0);
                }
                if (cb_2p.isChecked())
                {
                    sChecked += cb_2p.getText().toString().trim();
                    sChecked += "/";
                    iChecked.add(1);
                }
                else
                {
                    iChecked.add(0);
                }
                if (cb_3p.isChecked())
                {
                    sChecked += cb_3p.getText().toString().trim();
                    sChecked += "/";
                    iChecked.add(1);
                }
                else
                {
                    iChecked.add(0);
                }
                if (cb_4p.isChecked())
                {
                    sChecked += cb_4p.getText().toString().trim();
                    sChecked += "/";
                    iChecked.add(1);
                }
                else
                {
                    iChecked.add(0);
                }
                if (cb_5p.isChecked())
                {
                    sChecked += cb_5p.getText().toString().trim();
                    sChecked += "/";
                    iChecked.add(1);
                }
                else
                {
                    iChecked.add(0);
                }
                if (cb_japanese.isChecked())
                {
                    sChecked += cb_japanese.getText().toString().trim();
                    sChecked += "/";
                    iChecked.add(1);
                }
                else
                {
                    iChecked.add(0);
                }
                if (cb_western.isChecked())
                {
                    sChecked += cb_western.getText().toString().trim();
                    sChecked += "/";
                    iChecked.add(1);
                }
                else
                {
                    iChecked.add(0);
                }
                if (cb_korean.isChecked())
                {
                    sChecked += cb_korean.getText().toString().trim();
                    sChecked += "/";
                    iChecked.add(1);
                }
                else
                {
                    iChecked.add(0);
                }
                if (cb_chinese.isChecked())
                {
                    sChecked += cb_chinese.getText().toString().trim();
                    sChecked += "/";
                    iChecked.add(1);
                }
                else
                {
                    iChecked.add(0);
                }
                if (cb_flour.isChecked())
                {
                    sChecked += cb_flour.getText().toString().trim();
                    sChecked += "/";
                    iChecked.add(1);
                }
                else
                {
                    iChecked.add(0);
                }
                if (cb_fastfood.isChecked())
                {
                    sChecked += cb_fastfood.getText().toString().trim();
                    sChecked += "/";
                    iChecked.add(1);
                }
                else
                {
                    iChecked.add(0);
                }
                if (cb_meat.isChecked())
                {
                    sChecked += cb_meat.getText().toString().trim();
                    sChecked += "/";
                    iChecked.add(1);
                }
                else
                {
                    iChecked.add(0);
                }
                if (cb_etc.isChecked())
                {
                    sChecked += cb_etc.getText().toString().trim();
                    sChecked += "/";
                    iChecked.add(1);
                }
                else
                {
                    iChecked.add(0);
                }
                sChecked = sChecked.substring(0, sChecked.length() - 1);
                //카테고리 개수만큼 체크박스 개수 수정.

                FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                mDatabaseRef.child("TitleList").child(firebaseUser.getUid()).setValue(et_roomname.getText().toString());
                mDatabaseRef.child("sChecked").child(firebaseUser.getUid()).setValue(sChecked); // 체크된 정보(한글, 쉼표 없음)
                mDatabaseRef.child("iChecked").child(firebaseUser.getUid()).setValue(iChecked);  // 0과 1로 표현된 정보

                Intent intent = new Intent(Recruit_category.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}