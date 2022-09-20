package com.example.tribe;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.storage.StorageReference;

public class search extends AppCompatActivity {
    Button search;
    EditText etname,etid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);
        search=findViewById(R.id.search);
        etname=findViewById(R.id.name1);
        etid=findViewById(R.id.familyid1);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=etname.getText().toString();
                String id=etid.getText().toString();
                SharedPreferences sp2=getSharedPreferences("SearchName", 0);
                SharedPreferences.Editor Ed=sp2.edit();
                Ed.putString("name",name );
                Ed.putString("id",id );
                Ed.commit();
                Intent intent = new Intent(com.example.tribe.search.this, result.class);
                startActivity(intent);
            }
        });
    }
}