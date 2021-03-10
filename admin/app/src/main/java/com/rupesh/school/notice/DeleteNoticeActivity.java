package com.rupesh.school.notice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rupesh.school.R;

import java.util.ArrayList;
import java.util.List;

public class DeleteNoticeActivity extends AppCompatActivity {

    private RecyclerView deleteNoticeRecyclerView;
    private ProgressBar progressBar;
    private ArrayList<NoticeData> list;
    private NoticeAdapter adapter;
    private DatabaseError databaseError;
    public static ProgressDialog progressDialog;

    private DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_notice);
        progressDialog = new ProgressDialog(this);
        deleteNoticeRecyclerView = findViewById(R.id.deleteNoticeRecyclerView);
    //    progressBar = findViewById(R.id.progressBar);

        reference = FirebaseDatabase.getInstance().getReference().child("Notice");

        deleteNoticeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        deleteNoticeRecyclerView.setHasFixedSize(true);

        getNotice();

    }

    private void getNotice() {
        progressDialog.show();
        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              list = new ArrayList<>();
              for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                  NoticeData data = snapshot.getValue(NoticeData.class);
                  list.add(data);
              }
              adapter = new NoticeAdapter(DeleteNoticeActivity.this,list);
              adapter.notifyDataSetChanged();

             // progressBar.setVisibility(View.GONE);
              deleteNoticeRecyclerView.setAdapter(adapter);
                progressDialog.dismiss();

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //progressBar.setVisibility(View.GONE);

                progressDialog.dismiss();

                Log.e("xxxx", String.valueOf(error));
               // Toast.makeText(DeleteNoticeActivity.this,databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

 
}