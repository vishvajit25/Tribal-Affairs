package com.example.tribe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Districtsearch extends AppCompatActivity {

        Button search2,search,map,about;
        EditText district;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_districtsearch);
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
            district=findViewById(R.id.district);
            search2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(district.getText().toString().equals("")){
                        district.setError("COMPULSORY");
                    }
                    else {
                        String districtname = district.getText().toString();
                        SharedPreferences sp13 = getSharedPreferences("District", 0);
                        SharedPreferences.Editor Ed = sp13.edit();
                        Ed.putString("districtname", districtname);
                        Ed.commit();
                        String flag = "district";
                        SharedPreferences sp12 = getSharedPreferences("flag", 0);
                        SharedPreferences.Editor Ed2 = sp12.edit();
                        Ed2.putString("flag", flag);
                        Ed2.commit();
                        Intent intent = new Intent(com.example.tribe.Districtsearch.this, familyuser.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }