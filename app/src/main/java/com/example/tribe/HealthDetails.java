package com.example.tribe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class HealthDetails extends AppCompatActivity {
    Button map,about,search2,next;
    EditText e1,e2,e3;
    AutoCompleteTextView a1,a2,a3,a4,a5,a6,a7;
    RadioGroup rg1,rg2,rg3,rg4;
    FirebaseStorage storage;
    StorageReference storageReference;
    private FirebaseAuth mAuth;
    FirebaseFirestore fstore;
    DatabaseReference reff;
    RadioButton rg1rb1,rg1rb2,rg2rb1,rg2rb2,rg3rb1,rg3rb2,rg4rb1,rg4rb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_details);
        reff = FirebaseDatabase.getInstance().getReference();
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
        String[] yesno={"YES","NO"};
        next=findViewById(R.id.next);
        e1=findViewById(R.id.healthprobname);
        e2=findViewById(R.id.distancetohosp);
        a2=findViewById(R.id.childcare);
        e3=findViewById(R.id.healthissue);
        a1=findViewById(R.id.healthprob);
        a3=findViewById(R.id.illchild);
        a4=findViewById(R.id.med);
        a7=findViewById(R.id.delivery);
        a5=findViewById(R.id.tobaco);
        a6.findViewById(R.id.alcohol);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_selectable_list_item,yesno);
        a1.setAdapter(adapter);
        a1.setThreshold(1);
        a1.setTextColor(Color.BLACK);
        a1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                a1.showDropDown();
                return false;
            }
        });
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_selectable_list_item,yesno);
        a2.setAdapter(adapter2);
        a2.setThreshold(1);
        a2.setTextColor(Color.BLACK);
        a2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                a2.showDropDown();
                return false;
            }
        });
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_selectable_list_item,yesno);
        a3.setAdapter(adapter3);
        a3.setThreshold(1);
        a3.setTextColor(Color.BLACK);
        a3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                a3.showDropDown();
                return false;
            }
        });
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_selectable_list_item,yesno);
        a5.setAdapter(adapter5);
        a5.setThreshold(1);
        a5.setTextColor(Color.BLACK);
        a5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                a5.showDropDown();
                return false;
            }
        });
        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_selectable_list_item,yesno);
        a6.setAdapter(adapter6);
        a6.setThreshold(1);
        a6.setTextColor(Color.BLACK);
        a6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                a6.showDropDown();
                return false;
            }
        });
        String[] med={"MODERN","TRADITIONAL"};
        String[] delivery={"HOSPITAL","HOME"};
        ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_selectable_list_item,delivery);
        a7.setAdapter(adapter7);
        a7.setThreshold(1);
        a7.setTextColor(Color.BLACK);
        a7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                a7.showDropDown();
                return false;
            }
        });
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_selectable_list_item,med);
        a4.setAdapter(adapter3);
        a4.setThreshold(1);
        a4.setTextColor(Color.BLACK);
        a4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                a4.showDropDown();
                return false;
            }
        });




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp6=getSharedPreferences("Name",0);
                String key=sp6.getString("key", null);
                Log.d("Key",key);
                String healthprob = a1.getText().toString();
                String distance = e2.getText().toString();
                String med = a4.getText().toString();
                reff.child("Person").child(key).child("healthprob").setValue(healthprob);
                reff.child("Person").child(key).child("hospitaldistance").setValue(distance);
                Toast.makeText(HealthDetails.this, "FAMILY MEMBER DETAILS FILLED", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HealthDetails.this, BasicDetails.class);
                startActivity(intent);
            }
        });
    }
}