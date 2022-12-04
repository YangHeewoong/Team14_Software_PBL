package com.swPBL.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
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

    private Button search_btn;
    private CheckBox cb_lunch, cb_dinner, cb_midnight, cb_2p, cb_3p, cb_4p, cb_5p, cb_japanese, cb_western, cb_korean, cb_chinese, cb_flour, cb_fastfood, cb_meat, cb_etc;
    private int count, sim;
    private TextView tv_category;

    private ArrayList<Integer> arrayList, checkList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_category);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("SoftwarePBL-Team14");

        arrayList = new ArrayList<>();
        checkList = new ArrayList<>();
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

                mDatabaseRef.child("UserAccount").child("YnoqVFtUsIhw0U7rkD0LGUYmnWR2").child("RecruitCategory2").addValueEventListener(new ValueEventListener()
                {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot)
                    {
                        arrayList.clear();// 리스트 초기화

                        for (DataSnapshot datasnapshot : snapshot.getChildren())    // 반복문으로 데이터 리스트를 추출
                        {
                            arrayList.add(datasnapshot.getValue(Integer.class));    // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error)
                    {
                        Toast.makeText(Search_category.this, "에러", Toast.LENGTH_SHORT).show();
                    }
                });

                /*String b = Integer.toString(checkList.get(0));
                tv_category.setText(b);*/

                if (checkList.get(0) == arrayList.get(0))
                {
                    count += 1;
                }
                else if (checkList.get(1) == arrayList.get(1))
                {
                    count += 1;
                }
                else if (checkList.get(2) == arrayList.get(2))
                {
                    count += 1;
                }
                else if (checkList.get(3) == arrayList.get(3))
                {
                    count += 1;
                }
                else if (checkList.get(4) == arrayList.get(4))
                {
                    count += 1;
                }
                else if (checkList.get(5) == arrayList.get(5))
                {
                    count += 1;
                }
                else if (checkList.get(6) == arrayList.get(6))
                {
                    count += 1;
                }
                else if (checkList.get(7) == arrayList.get(7))
                {
                    count += 1;
                }
                else if (checkList.get(8) == arrayList.get(8))
                {
                    count += 1;
                }
                else if (checkList.get(9) == arrayList.get(9))
                {
                    count += 1;
                }
                else if (checkList.get(10) == arrayList.get(10))
                {
                    count += 1;
                }
                else if (checkList.get(11) == arrayList.get(11))
                {
                    count += 1;
                }
                else if (checkList.get(12) == arrayList.get(12))
                {
                    count += 1;
                }
                else if (checkList.get(13) == arrayList.get(13))
                {
                    count += 1;
                }
                else if (checkList.get(14) == arrayList.get(14))
                {
                    count += 1;
                }
                else
                {
                    count = 0;
                }

                sim = count / 14 * 100;
                String b = Integer.toString(sim);
                tv_category.setText(b);

                // Intent intent = new Intent(Search_category.this, View_list.class);
                // startActivity(intent);
            }
        });
    }
}