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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BankDetails extends AppCompatActivity {
    Button next,map,about,search;
    EditText bankname,loanamount;
    AutoCompleteTextView bankacc,loan,vehicle;
    String[] yesno = {"YES","NO"};
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_details);
        reff = FirebaseDatabase.getInstance().getReference();
        map=findViewById(R.id.map);
        bankacc=findViewById(R.id.bankacc);
        bankname=findViewById(R.id.nameofbank);
        vehicle=findViewById(R.id.vehicle);
        loan=findViewById(R.id.loan);
        loanamount=findViewById(R.id.loanamount);
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

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_selectable_list_item,yesno);
        bankacc.setAdapter(adapter);
        bankacc.setThreshold(1);
        bankacc.setTextColor(Color.BLACK);
        bankacc.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                bankacc.showDropDown();
                return false;
            }
        });
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_selectable_list_item,yesno);
        vehicle.setAdapter(adapter);
        vehicle.setThreshold(1);
        vehicle.setTextColor(Color.BLACK);
        vehicle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                vehicle.showDropDown();
                return false;
            }
        });
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_selectable_list_item,yesno);
        loan.setAdapter(adapter);
        loan.setThreshold(1);
        loan.setTextColor(Color.BLACK);
        loan.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                loan.showDropDown();
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

                String bankaccount=bankacc.getText().toString();
                String banknamestr=bankname.getText().toString();
                String loanstr = loan.getText().toString();
                String loanamm=loanamount.getText().toString();
                String vehiclestr=vehicle.getText().toString();
                reff.child("Person").child(key).child("amount").setValue(loanamm);
                reff.child("Person").child(key).child("bankacc").setValue(bankaccount);
                reff.child("Person").child(key).child("bankname").setValue(banknamestr);
                reff.child("Person").child(key).child("loan").setValue(loanstr);
                reff.child("Person").child(key).child("vehicle").setValue(vehiclestr);
                Intent intent = new Intent(BankDetails.this, EducationDetails.class);
                startActivity(intent);
            }
        });
    }
}