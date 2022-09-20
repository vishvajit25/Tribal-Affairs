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

import com.example.tribe.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HouseDetails extends AppCompatActivity {
    Button next,map,search,about;
    DatabaseReference reff;
    EditText given,size;
    AutoCompleteTextView own,type, yes;
    String[] yesno={"YES","NO"};
    String[] typestr={"CONCRETE","THATCHED WITH WOOD","OTHER"};
    String[] ownstr={"OWN","RENT"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reff = FirebaseDatabase.getInstance().getReference();
        setContentView(R.layout.activity_house_details);
        given = findViewById(R.id.modeofpurchase);
        size=findViewById(R.id.size);
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
        own=findViewById(R.id.ownorrent);
        type=findViewById(R.id.type);
        yes=findViewById(R.id.property);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_selectable_list_item,ownstr);
        own.setAdapter(adapter);
        own.setThreshold(1);
        own.setTextColor(Color.BLACK);
        own.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                own.showDropDown();
                return false;
            }
        });
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_selectable_list_item,typestr);
        type.setAdapter(adapter);
        type.setThreshold(1);
        type.setTextColor(Color.BLACK);
        type.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                type.showDropDown();
                return false;
            }
        });
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_selectable_list_item,yesno);
        yes.setAdapter(adapter);
        yes.setThreshold(1);
        yes.setTextColor(Color.BLACK);
        yes.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                yes.showDropDown();
                return false;
            }
        });
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp1=getSharedPreferences("Name",0);
                String key=sp1.getString("key", null);
                Log.d("Key",key);
                String mode = own.getText().toString();
                String htype = type.getText().toString();
                String prop = yes.getText().toString();
                String from = given.getText().toString();
                String lsize=size.getText().toString();
                reff.child("Person").child(key).child("property").setValue(prop);
                reff.child("Person").child(key).child("housegiven").setValue(mode);
                reff.child("Person").child(key).child("house").setValue(mode);
                reff.child("Person").child(key).child("housetype").setValue(htype);
                reff.child("Person").child(key).child("landsize").setValue(lsize);
//                reff.child("Person").child(key).child("age").setValue(agestring);
//                reff.child("Person").child(key).child("qualification").setValue(qua);
//                reff.child("Person").child(key).child("cert").setValue(certifi);
//                reff.child("Person").child(key).child("role").setValue(roles);
//                reff.child("Person").child(key).child("orgname").setValue(organiz);
//                reff.child("Person").child(key).child("income").setValue(incoming);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
    }
}