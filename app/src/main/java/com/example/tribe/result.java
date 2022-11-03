package com.example.tribe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class result extends AppCompatActivity {
    StorageReference storageReference;
    ProgressDialog progressDialog;
    ImageView imageView;
    EditText etname,etid;
    Button b1,search2,map,about,det;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        det=findViewById(R.id.detail);

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
        etname=findViewById(R.id.name1);
        etid=findViewById(R.id.familyid1);
        det.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etname.getText().toString();
                String id = etid.getText().toString();
                SharedPreferences sp20 = getSharedPreferences("SearchName", 0);
                SharedPreferences.Editor Ed = sp20.edit();
                Ed.putString("name", name);
                Ed.putString("id", id);
                Ed.commit();
                startActivity(new Intent(getApplicationContext(), userlist.class));
                finish();
            }
        });
        b1=findViewById(R.id.btnsearch);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etname.getText().toString();
                String id = etid.getText().toString();
                imageView = findViewById(R.id.image);


                progressDialog = new ProgressDialog(result.this);
                progressDialog.setMessage("FETCHING IMAGE...");
                progressDialog.setCancelable(false);
                progressDialog.show();

//        String imageid=name+id;
                storageReference= FirebaseStorage.getInstance().getReference(name+id+".jpg");
                try {
                    File localfile=File.createTempFile("tempfile",".jpg");
                    storageReference.getFile(localfile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            if(progressDialog.isShowing())
                                progressDialog.dismiss();

                            Bitmap bitmap = BitmapFactory.decodeFile(localfile.getAbsolutePath());
                            imageView.setImageBitmap(bitmap);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            if(progressDialog.isShowing())
                                progressDialog.dismiss();
                            Toast.makeText(result.this, "FAILED TO RETRIEVE",Toast.LENGTH_SHORT);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });



    }

}