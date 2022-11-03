package com.example.tribe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Panchayatsearch extends AppCompatActivity {
    Button search2,search,map,about;
    EditText panchayat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panchayatsearch);
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
        panchayat=findViewById(R.id.panchayat);
        search2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(panchayat.getText().toString().equals("")){
                    panchayat.setError("COMPULSORY");
                }
                else {
                    String blockname = panchayat.getText().toString();
                    SharedPreferences sp8 = getSharedPreferences("Panchayat", 0);
                    SharedPreferences.Editor Ed = sp8.edit();
                    Ed.putString("panchayatname", blockname);
                    Ed.commit();
                    String flag = "panchayat";
                    SharedPreferences sp12 = getSharedPreferences("flag", 0);
                    SharedPreferences.Editor Ed2 = sp12.edit();
                    Ed2.putString("flag", flag);
                    Ed2.commit();
                    Intent intent = new Intent(com.example.tribe.Panchayatsearch.this, familyuser.class);
                    startActivity(intent);
                }
            }
        });
    }
}