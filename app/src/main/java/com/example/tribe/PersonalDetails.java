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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class PersonalDetails extends AppCompatActivity {
    Button next;
    Button map,search,about;
    EditText rel,subcaste,age,relation,qual,cert,role,org,income;
    AutoCompleteTextView marriage,emp;
    FirebaseStorage storage;
    StorageReference storageReference;
    private FirebaseAuth mAuth;
    FirebaseFirestore fstore;
    DatabaseReference reff;
    String[] yesno={"YES","NO"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);
        rel=findViewById(R.id.religion);
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
        subcaste=findViewById(R.id.caste);
        reff = FirebaseDatabase.getInstance().getReference();
        age=findViewById(R.id.age);
        relation=findViewById(R.id.relationship);
        marriage = findViewById(R.id.marriage);
        emp = findViewById(R.id.employment);
        qual=findViewById(R.id.qualification);
        cert=findViewById(R.id.certification);
        role=findViewById(R.id.role);
        org=findViewById(R.id.companyname);
        income=findViewById(R.id.income);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_selectable_list_item,yesno);
        marriage.setAdapter(adapter);
        marriage.setThreshold(1);
        marriage.setTextColor(Color.BLACK);
        marriage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                marriage.showDropDown();
                return false;
            }
        });
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_selectable_list_item,yesno);
        emp.setAdapter(adapter2);
        emp.setThreshold(1);
        emp.setTextColor(Color.BLACK);
        emp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                emp.showDropDown();
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
                String religion = rel.getText().toString();
                String caste = subcaste.getText().toString();
                String agestring = age.getText().toString();
                String relationship = relation.getText().toString();
                String mar = marriage.getText().toString();
                String employ = emp.getText().toString();
                String qua = qual.getText().toString();
                String certifi = cert.getText().toString();
                String roles = role.getText().toString();
                String organiz = org.getText().toString();
                String incoming = income.getText().toString();
                reff.child("Person").child(key).child("marriage").setValue(mar);
                reff.child("Person").child(key).child("caste").setValue(caste);
                reff.child("Person").child(key).child("religion").setValue(religion);
                reff.child("Person").child(key).child("relationship").setValue(relationship);
                reff.child("Person").child(key).child("emp").setValue(employ);
                reff.child("Person").child(key).child("age").setValue(agestring);
                reff.child("Person").child(key).child("qualification").setValue(qua);
                reff.child("Person").child(key).child("cert").setValue(certifi);
                reff.child("Person").child(key).child("role").setValue(roles);
                reff.child("Person").child(key).child("orgname").setValue(organiz);
                reff.child("Person").child(key).child("income").setValue(incoming);


                startActivity(new Intent(getApplicationContext(), BankDetails.class));
                finish();
            }
        });
    }
}