package com.example.tribe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
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

public class MainActivity extends AppCompatActivity {
    String[] type = {"Nuclear", "Joint"};
    Button create;
    EditText familyheadname, id,address,tribename,familysize;
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
        setContentView(R.layout.activity_main);
        familyheadname = findViewById(R.id.familyheadname);
        id=findViewById(R.id.familyid);
        address = findViewById(R.id.familyaddress);
        tribename = findViewById(R.id.tribename);
        familysize=findViewById(R.id.familysize);
        familytype=findViewById(R.id.familytype);
        create=findViewById(R.id.create);
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
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String fheadname = familyheadname.getText().toString().trim();
            String fid = id.getText().toString().trim();
            String faddress = address.getText().toString().trim();
            String ftribename = tribename.getText().toString().trim();
            String ftype = familytype.getText().toString().trim();
            String fsize = familysize.getText().toString().trim();
            Family family = new Family(fheadname, fid, faddress,ftribename,fsize,ftype);
            reff.child("Family").push().setValue(family);
            Toast.makeText(MainActivity.this, "New Family Created", Toast.LENGTH_SHORT).show();

            }
        });
    }
}