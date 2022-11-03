package com.example.tribe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Taluksearch extends AppCompatActivity {
    Button search2,search,map,about;
    EditText taluk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taluksearch);
        map=findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), news.class));
                finish();
            }
        });
        search=findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainSearch.class));
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
        search2=findViewById(R.id.btnsearch);
        taluk=findViewById(R.id.taluk);
        search2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(taluk.getText().toString().equals("")){
                    taluk.setError("COMPULSORY");
                }
                else {
                    String blockname = taluk.getText().toString();
                    SharedPreferences sp6 = getSharedPreferences("Taluk", 0);
                    SharedPreferences.Editor Ed = sp6.edit();
                    Ed.putString("talukname", blockname);
                    Ed.commit();
                    String flag = "taluk";
                    SharedPreferences sp12 = getSharedPreferences("flag", 0);
                    SharedPreferences.Editor Ed2 = sp12.edit();
                    Ed2.putString("flag", flag);
                    Ed2.commit();
                    Intent intent = new Intent(com.example.tribe.Taluksearch.this, familyuser.class);
                    startActivity(intent);
                }
            }
        });
    }
}