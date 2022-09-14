package com.example.tribe;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;


public class Register extends AppCompatActivity {

    public static final String TAG = "";
    private FirebaseAuth mAuth;
    Button button, register;
    TextView textView, login;
    EditText pswd, emailid, phoneno, name;
    FirebaseFirestore fstore;
    DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reff = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), Register.class));
            finish();
        }
        setContentView(R.layout.activity_register);
        EditText pswd = (EditText) findViewById(R.id.password);
        EditText emailid = (EditText) findViewById(R.id.email);
        EditText phoneno = (EditText) findViewById(R.id.phno);
        EditText name = (EditText) findViewById(R.id.name);
        Button register = (Button) findViewById(R.id.rgbutton);

//        DAOapplicant dao = new DAOapplicant();
        register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailid.getText().toString().trim();
                String password = pswd.getText().toString().trim();
                String Fullname = name.getText().toString();
                String phonenumber = phoneno.getText().toString();
                Officer officer = new Officer(name.getText().toString(),emailid.getText().toString(), phoneno.getText().toString());

                if (TextUtils.isEmpty((email))) {
                    emailid.setError("Email is required.");
                }
                if (TextUtils.isEmpty(password)) {
                    pswd.setError("Password cant be empty.");
                }
                if (password.length() < 6) {
                    pswd.setError("Password must  be more than 6 characters.");
                }
                if (TextUtils.isEmpty(phonenumber)) {
                    phoneno.setError("Phone Number cant be empty.");
                }
                if (TextUtils.isEmpty(Fullname)) {
                    name.setError("Name cant be empty.");
                } else {
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
//
                                reff.child("Officer").child(mAuth.getUid()).child("Name").setValue(Fullname);
                                reff.child("Officer").child(mAuth.getUid()).child("Email Id").setValue(email);
                                reff.child("Officer").child(mAuth.getUid()).child("Phone Number").setValue(phonenumber);

                                finish();
                                FirebaseAuth.getInstance().signOut();
                            } else {
                                Toast.makeText(Register.this, "ERROR !!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
//        login.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Register.this,Login.class));
//            }
//        });

    }

}

