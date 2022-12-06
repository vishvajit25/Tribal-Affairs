package com.example.tribe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class Jharkhand extends AppCompatActivity { //here state name should not have any space, follow caps (EG:TamilNadu)
    String[] type = {"Nuclear", "Joint"};
    Button create,next;
    Button map,about,search;
    String state = "Jharkhand"; //Here have space
    EditText familyheadname, id,address,tribename,familysize,fditrict,fblock,ftaluk,fpanchayat;
    AutoCompleteTextView familytype;
    private FirebaseAuth mAuth;
    FirebaseFirestore fstore;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reff = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        setContentView(R.layout.activity_jharkhand);
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
        familyheadname = findViewById(R.id.familyheadname);
        id=findViewById(R.id.familyid);
        address = findViewById(R.id.familyaddress);
        tribename = findViewById(R.id.tribename);
        familysize=findViewById(R.id.familysize);
        familytype=findViewById(R.id.familytype);
        create=findViewById(R.id.create);
        ftaluk = findViewById(R.id.taluk);
        fpanchayat=findViewById(R.id.panchayat);
        fblock=findViewById(R.id.block);
        fditrict=findViewById(R.id.district);
        next=findViewById(R.id.next);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_selectable_list_item,type);
        familytype.setAdapter(adapter);
        familytype.setThreshold(1);
        familytype.setTextColor(Color.BLACK);
        familytype.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                familytype.showDropDown();
                return false;
            }
        });
//        String fheadname2 = familyheadname.getText().toString().trim();
//        String fid2 = id.getText().toString().trim();
//        String faddress2 = address.getText().toString().trim();
//        String ftribename2 = tribename.getText().toString().trim();
//        String ftype2 = familytype.getText().toString().trim();
//        String fsize2 = familysize.getText().toString().trim();
//        String district2 = fditrict.getText().toString().trim();
//        String taluk2=ftaluk.getText().toString().trim();
//        String panchayat2=fpanchayat.getText().toString().trim();
//        String state2="Jharkhand";
//        String block2 = fblock.getText().toString().trim();
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (familyheadname.getText().toString().equals("")) {
                    familyheadname.setError("FILL THIS FIELD");
                }
                if (id.getText().toString().equals("")) {
                    id.setError("FILL THIS FIELD");
                }
                if (fditrict.getText().toString().equals("")) {
                    fditrict.setError("FILL THIS FIELD");
                }
                if (fblock.getText().toString().equals("")) {
                    fblock.setError("FILL THIS FIELD");
                }
                if (ftaluk.getText().toString().equals("")) {
                    ftaluk.setError("FILL THIS FIELD");
                }
                else {
                    String fheadname = familyheadname.getText().toString().trim();
                    String fid = id.getText().toString().trim();
                    String faddress = address.getText().toString().trim();
                    String ftribename = tribename.getText().toString().trim();
                    String ftype = familytype.getText().toString().trim();
                    String fsize = familysize.getText().toString().trim();
                    String district = fditrict.getText().toString().trim();
                    String taluk = ftaluk.getText().toString().trim();
                    String panchayat = fpanchayat.getText().toString().trim();
                    String state = "Jharkhand";
                    String block = fblock.getText().toString().trim();
                    char id1 = state.charAt(0);
                    char id2 = district.charAt(0);
                    char id3 = block.charAt(0);
                    String finalid = (String.valueOf(id1) + String.valueOf(id2) + String.valueOf(id3)).toString();
                    Log.d("ID", finalid + fid);
                    Family family = new Family(fheadname, finalid + fid, faddress, fsize, ftype, state, district, block, taluk, panchayat, ftribename);
                    reff.child("Family").push().setValue(family);
                    Toast.makeText(Jharkhand.this, "New Family Created", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), Jharkhand.class));
                    finish();
                }

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Jharkhand.this, BasicDetails.class);
                startActivity(intent);
            }
        });
    }
}