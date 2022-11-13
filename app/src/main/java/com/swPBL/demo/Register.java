package com.swPBL.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity
{
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    private EditText email_input, pwd_input, birth_input, nickname_input;
    private Button register_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();     // FirebaseAuth 인스턴스를 가져옴
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("SoftwarePBL-Team14");

        email_input = findViewById(R.id.email_input);
        pwd_input = findViewById(R.id.pwd_input);
        birth_input = findViewById(R.id.birth_input);
        nickname_input = findViewById(R.id.nickname_input);
        register_btn = findViewById(R.id.register_btn);

        register_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String strEmail = email_input.getText().toString().trim();
                String strPwd = pwd_input.getText().toString().trim();
                String strBirth = birth_input.getText().toString().trim();
                String strNickname = nickname_input.getText().toString().trim();
                // 공백인 부분을 제거하고 보여주는 trim();
                mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                            UserAccount account = new UserAccount();
                            account.setIdToken(firebaseUser.getUid());
                            account.setEmailId(firebaseUser.getEmail());
                            account.setPassword(strPwd);

                            Toast.makeText(Register.this, "회원가입에 성공하였습니다.", Toast.LENGTH_SHORT).show();

                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);

                            Intent intent = new Intent(Register.this, Login.class);
                            startActivity(intent);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(Register.this, "등록 에러", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });
            }
        });
    }
}