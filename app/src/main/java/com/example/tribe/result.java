package com.example.tribe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        imageView = findViewById(R.id.image);
        SharedPreferences sp3=getSharedPreferences("SearchName",0);
        String name=sp3.getString("name", null);
        String id=sp3.getString("id", null);

        progressDialog = new ProgressDialog(result.this);
        progressDialog.setMessage("FETCHING IMAGE...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        String imageid=name+id;
        storageReference= FirebaseStorage.getInstance().getReference(imageid+".jpg");
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

}