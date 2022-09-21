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
    Button search,search2,map,about;
    EditText etname,etid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);
        search=findViewById(R.id.search);
        etname=findViewById(R.id.name1);
        etid=findViewById(R.id.familyid1);
        map=findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), news.class));
                finish();
            }
        });
        search2=findViewById(R.id.search);
        search2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), search.class));
                finish();
            }
        });
        about=findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), about.class));
                finish();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etname.getText().toString().equals("")){
                    etname.setError("COMPULSORY");
                }
                else if(etid.getText().toString().equals("")){
                    etid.setError("COMPULSORY");
                }
                else {
                    String name = etname.getText().toString();
                    String id = etid.getText().toString();
                    SharedPreferences sp2 = getSharedPreferences("SearchName", 0);
                    SharedPreferences.Editor Ed = sp2.edit();
                    Ed.putString("name", name);
                    Ed.putString("id", id);
                    Ed.commit();
                    Intent intent = new Intent(com.example.tribe.search.this, userlist.class);
                    startActivity(intent);
                }
            }
        });
    }
}