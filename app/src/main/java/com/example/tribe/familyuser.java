package com.example.tribe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class familyuser extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    fMyAdapter fmyAdapter;
    ArrayList<Fuser> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familyuser);
        recyclerView = findViewById(R.id.familyuserlist);
        databaseReference= FirebaseDatabase.getInstance().getReference("Family");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        fmyAdapter= new fMyAdapter(this,list);
        recyclerView.setAdapter(fmyAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    Fuser fuser = dataSnapshot.getValue(Fuser.class);
                    SharedPreferences sp11=getSharedPreferences("flag",0);
                    String flag=sp11.getString("flag", null);
//                    list.add(user);
                    SharedPreferences sp5=getSharedPreferences("Block",0);
                    String blockname=sp5.getString("blockname", null);
                    SharedPreferences sp7=getSharedPreferences("Taluk",0);
                    String talukname=sp7.getString("talukname", null);
                    SharedPreferences sp9=getSharedPreferences("Panchayat",0);
                    String panchayatname=sp9.getString("panchayatname", null);
                    SharedPreferences sp15=getSharedPreferences("District",0);
                    String districtname=sp15.getString("districtname", null);
                    Log.d("name",blockname);
                    Log.d("name",blockname);
                    Log.d("name",panchayatname);
                    Log.d("flag",flag);
                    Log.d("district",districtname);

                    if(flag.equals("block")) {
                        if(blockname.equals(fuser.getFamilyblock())) {
                            list.add(fuser);
                    }
                    }
                    else if(flag.equals("taluk")) {
                        if (talukname.equals(fuser.getFamilytaluk())) {
                            list.add(fuser);
                        }
                    }
                    if(flag.equals("panchayat")) {
                        if (panchayatname.equals(fuser.getFamilypanchayat())) {
                            list.add(fuser);
                        }
                    }
                    if(flag.equals("district")) {
                        if (districtname.equals(fuser.getFamilydistrict())) {
                            list.add(fuser);
                        }
                    }
//
//                    if(blockname.equals(fuser.getFamilyblock()) || talukname.equals(fuser.getFamilytaluk()) || panchayatname.equals(fuser.getFamilypanchayat())) {
//                        list.add(fuser);
//                    }

                }
                fmyAdapter.notifyDataSetChanged();
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}