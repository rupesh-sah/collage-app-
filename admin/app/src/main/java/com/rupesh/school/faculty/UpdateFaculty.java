 package com.rupesh.school.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rupesh.school.R;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {

    private FloatingActionButton fab;
    private RecyclerView computerDepartment, biologyDepartment, mathDepartment, physicDepartment, chemistryDepartment;
    private LinearLayout computerNoData, biologyNoData, mathNoData, physicNoData,chemistryNoData;
    private List<TeacherData> list1, list2, list3, list4, list5;
    private TeacherAdapter adapter;

   // private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        computerDepartment = findViewById(R.id.computerDepartment);
        biologyDepartment= findViewById(R.id.biologyDepartment);
        mathDepartment = findViewById(R.id.mathDepartment);
        physicDepartment = findViewById(R.id.physicDepartment);
        chemistryDepartment = findViewById(R.id.chemistryDepartment);

        computerNoData = findViewById(R.id.computerNoData);
        biologyNoData = findViewById(R.id.biologyNoData);
        mathNoData = findViewById(R.id.mathNoData);
        physicNoData = findViewById(R.id.physicNoData);
        chemistryNoData = findViewById(R.id.chemistryNoData);

       // reference = FirebaseDatabase.getInstance().getReference().child("teachers");

                computerDepartment();
                biologyDepartment();
                mathDepartment();
                physicDepartment ();
                chemistryDepartment();


        fab = findViewById(R.id.fab);


            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  Intent  intent=new Intent(UpdateFaculty.this, AddTeachers.class);
                    startActivity(intent);
                }
            });


    }

    private void computerDepartment() {
        DatabaseReference reference;
        reference = FirebaseDatabase.getInstance().getReference().child("teachers");
        reference = reference.child("computer_science");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){

                        computerNoData.setVisibility(View.VISIBLE);
                        computerDepartment.setVisibility(View.GONE);
                    }else {
                    computerNoData.setVisibility(View.GONE);
                    computerDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1=new ArrayList<>();
                        list1.add(data);
                    }
                    computerDepartment.setHasFixedSize(true);
                    computerDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list1, UpdateFaculty.this,"computer_science");
                    computerDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void biologyDepartment() {
       DatabaseReference reference;
        reference = FirebaseDatabase.getInstance().getReference().child("teachers");
        reference = reference.child("biology");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){

                        biologyNoData.setVisibility(View.VISIBLE);
                        biologyDepartment.setVisibility(View.GONE);


                }  else
                     {
                    biologyNoData.setVisibility(View.GONE);
                    biologyDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    biologyDepartment.setHasFixedSize(true);
                    biologyDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list2,UpdateFaculty.this,"biology");
                    biologyDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void mathDepartment() {
        DatabaseReference reference;
        reference = FirebaseDatabase.getInstance().getReference().child("teachers");
        reference = reference.child("math");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists())
                    {
                        mathNoData.setVisibility(View.VISIBLE);
                        mathDepartment.setVisibility(View.GONE);
                    }else

                 {
                    mathNoData.setVisibility(View.GONE);
                    mathDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    mathDepartment.setHasFixedSize(true);
                    mathDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list3,UpdateFaculty.this,"math");
                    mathDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void physicDepartment() {
        DatabaseReference reference;
        reference = FirebaseDatabase.getInstance().getReference().child("teachers");
        reference = reference.child("physics");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists())
                    {

                        physicNoData.setVisibility(View.VISIBLE);
                        physicDepartment.setVisibility(View.GONE);

                }else{

                    physicNoData.setVisibility(View.GONE);
                    physicDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    physicDepartment.setHasFixedSize(true);
                    physicDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list4,UpdateFaculty.this,"physics");
                    physicDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void chemistryDepartment() {
      DatabaseReference reference;
       reference = FirebaseDatabase.getInstance().getReference().child("teachers");
        reference = reference.child("chemistry");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists())
                    {
                        chemistryNoData.setVisibility(View.VISIBLE);
                        chemistryDepartment.setVisibility(View.GONE);

                }else
                 {
                    chemistryNoData.setVisibility(View.GONE);
                    chemistryDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    chemistryDepartment.setHasFixedSize(true);
                    chemistryDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list5,UpdateFaculty.this,"chemistry");
                    chemistryDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

}