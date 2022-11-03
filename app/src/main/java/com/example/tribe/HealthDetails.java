package com.example.tribe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class HealthDetails extends AppCompatActivity {
    Button map,about,search2,next;
    EditText e1,e2,e3;
    AutoCompleteTextView a1,a2,a3;
    RadioGroup rg1,rg2,rg3,rg4;
    RadioButton rg1rb1,rg1rb2,rg2rb1,rg2rb2,rg3rb1,rg3rb2,rg4rb1,rg4rb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_details);
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
        next=findViewById(R.id.next);
        e1=findViewById(R.id.healthprobname);
        e2=findViewById(R.id.distancetohosp);
        a2=findViewById(R.id.childcare);
        e3=findViewById(R.id.healthissue);
        a1=findViewById(R.id.healthprob);
        a3=findViewById(R.id.illchild);
        rg1=findViewById(R.id.rg1);
        rg2=findViewById(R.id.rg2);
        rg3=findViewById(R.id.rg3);
        rg4=findViewById(R.id.rg4);
        rg1rb1=findViewById(R.id.rg1rb1);
        rg1rb2=findViewById(R.id.rg1rb2);
        rg2rb1=findViewById(R.id.rg2rb1);
        rg2rb2=findViewById(R.id.rg2rb2);
        rg3rb1=findViewById(R.id.rg3rb1);
        rg3rb2=findViewById(R.id.rg3rb2);
        rg4rb1=findViewById(R.id.rg4rb1);
        rg4rb2=findViewById(R.id.rg4rb2);
        String tobacco="";
        String alcohol="";
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch(i)
                {
                    case R.id.rg1rb1:
                       String medicine = "MODERN";
                    case R.id.rg1rb2:
                        medicine ="TRADITION";
                }
            }
        });
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch(i)
                {
                    case R.id.rg2rb1:
                        String delivery = "HOSPITAL";
                    case R.id.rg2rb2:
                        delivery="HOME";
                }
            }
        });
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch(i)
                {
                    case R.id.rg3rb1:
                        String tobacco = "YES";
                    case R.id.rg3rb2:
                        tobacco="NO";
                }
            }
        });
        rg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch(i)
                {
                    case R.id.rg4rb1:
                        String alcohol = "YES";
                    case R.id.rg4rb2:
                        alcohol="NO";
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HealthDetails.this, "FAMILY MEMBER DETAILS FILLED", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HealthDetails.this, BasicDetails.class);
                startActivity(intent);
            }
        });
    }
}