package com.example.tribe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tribe.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.api.Context;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

public class BasicDetails extends AppCompatActivity {
    Button next, pic;
    String[] genderarr = {"MALE", "FEMALE","PREFER NOT TO SAY"};
    ImageView image;
    EditText etname,fid,aadhar,phoneno,organization;
    AutoCompleteTextView gender;
    FirebaseStorage storage;
    StorageReference storageReference;
    private FirebaseAuth mAuth;
    FirebaseFirestore fstore;
    DatabaseReference reff;
    FusedLocationProviderClient client;
    private ArrayList<String> pathArray;
    private int array_position;
    private Uri filePath;
    private StorageReference mStorageRef;
    private FirebaseAuth auth;
    Uri imageUri = null;
    private ProgressDialog mProgressDialog;
    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_details);
        next = findViewById(R.id.next);
        image = findViewById(R.id.imageview);
        etname = findViewById(R.id.name1);
        aadhar = findViewById(R.id.aadhar);
        reff = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        phoneno = findViewById(R.id.phoneno);
        organization = findViewById(R.id.org);
        gender = findViewById(R.id.gender);
        fid = findViewById(R.id.familyid1);
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_selectable_list_item,genderarr);
        gender.setAdapter(adapter);
        gender.setThreshold(1);
        gender.setTextColor(Color.BLACK);
        gender.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gender.showDropDown();
                return false;
            }
        });
        pic = findViewById(R.id.pic);
        mStorageRef = FirebaseStorage.getInstance().getReference();
        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
                if (ContextCompat.checkSelfPermission(BasicDetails.this
                        , Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED &&
                        ContextCompat.checkSelfPermission(BasicDetails.this
                                , Manifest.permission.ACCESS_COARSE_LOCATION)
                                == PackageManager.PERMISSION_GRANTED) {
                                    }else{
                    requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION
                            ,Manifest.permission.ACCESS_COARSE_LOCATION},100);                }
            }
        });
        String name=etname.getText().toString();
        String aadharno = aadhar.getText().toString();
        String famid=fid.getText().toString();
        String phonenumber=phoneno.getText().toString();
        String org=organization.getText().toString();
        String genderstr = gender.getText().toString();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etname.getText().toString().equals("")) {
                    etname.setError("Name is required.");
                }
                if (fid.getText().toString().equals("")) {
                    fid.setError("FamilyID cant be empty.");
                }
                else {
                    String str = etname.getText().toString();
                    String str2 = fid.getText().toString();
                    StorageReference imagenameref = mStorageRef.child(str + str2 + ".jpg");
                    image.setDrawingCacheEnabled(true);
                    image.buildDrawingCache();
                    Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    byte[] data = baos.toByteArray();
                    UploadTask uploadTask = imagenameref.putBytes(data);
                    uploadTask.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            // Handle unsuccessful uploads
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(BasicDetails.this, "IMAGE UPLOADED SUCCESSFULLY !", Toast.LENGTH_SHORT).show();
                            // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                            // ...
                        }
                    });
                    String name=etname.getText().toString();
                    String aadharno = aadhar.getText().toString();
                    String famid=fid.getText().toString();
                    String phonenumber=phoneno.getText().toString();
                    String org=organization.getText().toString();
                    String genderstr = gender.getText().toString();
                    SharedPreferences sp=getSharedPreferences("Name", 0);
                    SharedPreferences.Editor Ed=sp.edit();
                    Ed.putString("key",name+famid );
                    Ed.commit();
                    Person person = new Person(name,famid,aadharno,phonenumber,org,genderstr,"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","");
                    String key = reff.child("Person").push().getKey();
                    reff.child("Person").child(name+famid).setValue(person);
                    Toast.makeText(BasicDetails.this, key, Toast.LENGTH_SHORT).show();
                    Log.d("tag",key);
                    Intent intent = new Intent(BasicDetails.this, PersonalDetails.class);
                    startActivity(intent);
                }
            }
        });


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            Bitmap captureImage = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(captureImage);
        }
    }

}