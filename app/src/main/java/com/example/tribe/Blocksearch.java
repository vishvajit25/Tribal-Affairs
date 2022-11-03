package com.example.tribe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Blocksearch extends AppCompatActivity {
    Button search2,search,map,about;
    EditText block;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocksearch);
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
        block=findViewById(R.id.block);
        search2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(block.getText().toString().equals("")){
                    block.setError("COMPULSORY");
                }
                else {
                    String blockname = block.getText().toString();
                    String flag = "block";
                    SharedPreferences sp4 = getSharedPreferences("Block", 0);
                    SharedPreferences.Editor Ed = sp4.edit();
                    Ed.putString("blockname", blockname);
                    Ed.commit();
                    SharedPreferences sp10 = getSharedPreferences("flag", 0);
                    SharedPreferences.Editor Ed1 = sp10.edit();
                    Ed1.putString("flag", flag);
                    Ed1.commit();
                    Intent intent = new Intent(com.example.tribe.Blocksearch.this, familyuser.class);
                    startActivity(intent);
                }
            }
        });
    }
}