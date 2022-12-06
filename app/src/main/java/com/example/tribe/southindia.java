package com.example.tribe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class southindia extends AppCompatActivity {
    Button tn,kl,ap,tl,kn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_southindia);
        tn=findViewById(R.id.tn);
        tn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(southindia.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ap=findViewById(R.id.andra);
        ap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(southindia.this, AndhraPradesh.class);
                startActivity(intent);
            }
        });
        kl=findViewById(R.id.kerala);
        kl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(southindia.this, Kerala.class);
                startActivity(intent);
            }
        });
        tl=findViewById(R.id.telengana);
        tl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(southindia.this, Telangana.class);
                startActivity(intent);
            }
        });
        kn=findViewById(R.id.kn);
        kn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(southindia.this, Karnataka.class);
                startActivity(intent);
            }
        });
    }
}