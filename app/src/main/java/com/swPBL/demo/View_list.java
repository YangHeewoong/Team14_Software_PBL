package com.swPBL.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class View_list extends AppCompatActivity
{
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseRef;

    private ListView listView;

    private ArrayList<String> sChecked;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_list);

        // 컴포넌트 변수에 담기
        listView = findViewById(R.id.listView);

        sChecked = new ArrayList<>();

        // 어댑터 초기화
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sChecked);

        //데이터베이스 초기화
        mFirebaseDatabase = FirebaseDatabase.getInstance();

        // 레퍼런스 초기화
        mDatabaseRef = mFirebaseDatabase.getReference("SoftwarePBL-Team14");
        getValue();
    }

    private void getValue()
    {
        mDatabaseRef.child("TitleList").addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                //리스트 초기화
                sChecked.clear();
                Log.v("TAG", "64번");
                for (DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    // 데이터 가져오기 (emailId 이름으로 된 값을 변수에 담는다.
                    String sValue = dataSnapshot.getValue(String.class);

                    // 리스트에 변수를 담는다.
                    sChecked.add(sValue);
                }

                Collections.sort(sChecked);

                // 리스트뷰 어댑터 설정
                listView.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {
                Log.v("TAG", "cancel");
            }
        });
    }
}