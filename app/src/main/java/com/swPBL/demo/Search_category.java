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
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Search_category extends AppCompatActivity
{
    private Button search_btn;
    private CheckBox cb_lunch, cb_dinner, cb_midnight, cb_2p, cb_3p, cb_4p, cb_5p, cb_japanese, cb_western, cb_korean, cb_chinese, cb_flour, cb_fastfood, cb_meat, cb_etc;

    private ArrayList<Integer> checkList;
    private ArrayList<Integer> iChecked;

    private int count, similar;

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_category);

        checkList = new ArrayList<>();
        iChecked = new ArrayList<>();

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
                Log.v("TAG", "196번");
                // getValue();
                /*for (int i = 0; i < checkList.size(); i++)
                {
                    if (checkList.get(i).equals(iChecked.get(i)))
                    {
                        count += 1;
                    }
                }
                similar = count / 14 * 100;
                Log.v("TAG", "similar");
                mDatabaseRef.child("Similarity").child("asd").setValue(similar);
                Log.v("TAG", "208번");*/
                Intent intent = new Intent(Search_category.this, View_list.class);
                startActivity(intent);
            }
        });
    }

    private void getValue()
    {
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("SoftwarePBL-Team14");
        mDatabaseRef.child("iChecked").addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                for (DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    iChecked.clear();
                    mDatabaseRef.child("iChecked").child(dataSnapshot.toString()).addValueEventListener(new ValueEventListener()
                    {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot1)
                        {
                            for (DataSnapshot dataSnapshot1 : snapshot1.getChildren())
                            {
                                int iValue = dataSnapshot1.getValue(Integer.class);
                                iChecked.add(iValue);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error)
                        {

                        }
                    });
                    Log.v("TAG", "245번");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {
                Log.v("TAG", "cancel2");
            }
        });
    }
}