package com.example.tribe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tribe.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class EducationDetails extends AppCompatActivity {
    Button next,map,about,search2;
    EditText e1,e2,e3,e4;
    FirebaseStorage storage;
    StorageReference storageReference;
    private FirebaseAuth mAuth;
    FirebaseFirestore fstore;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_details);
        e1=findViewById(R.id.highestedu);
        e2=findViewById(R.id.nameofedu);
        e3=findViewById(R.id.distance);
        e4=findViewById(R.id.eduexpense);
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
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp1=getSharedPreferences("Name",0);
                String key=sp1.getString("key", null);
                Log.d("Key",key);
                String highedu=e1.getText().toString();
                String nameofedu=e2.getText().toString();
                String distance = e3.getText().toString();
                String expense=e4.getText().toString();
                reff.child("Person").child(key).child("highed").setValue(highedu);
                reff.child("Person").child(key).child("nameofed").setValue(nameofedu);
                reff.child("Person").child(key).child("distanceofed").setValue(distance);
                reff.child("Person").child(key).child("edexpense").setValue(expense);
                Intent intent = new Intent(EducationDetails.this, HouseDetails.class);
                startActivity(intent);
            }
        });
    }
}