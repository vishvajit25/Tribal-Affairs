package com.example.tribe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.tribe.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class PersonalDetails extends AppCompatActivity {
    Button next;
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
        subcaste=findViewById(R.id.caste);
        age=findViewById(R.id.age);
        relation=findViewById(R.id.relationship);
        marriage = findViewById(R.id.marriage);
        emp = findViewById(R.id.employment);
        qual=findViewById(R.id.qualification);
        cert=findViewById(R.id.certification);
        role=findViewById(R.id.role);
        org=findViewById(R.id.org);
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

                startActivity(new Intent(getApplicationContext(), BankDetails.class));
                finish();
            }
        });
    }
}