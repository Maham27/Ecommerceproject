package com.example.ecommerceproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ourallproducts extends AppCompatActivity {

    RecyclerView recyclerView;
    List<allproducts> l;
    allpadptr alladptor;
    FirebaseFirestore b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ourallproducts);
        recyclerView=findViewById(R.id.allrecycler);

        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        l=new ArrayList<>();
        alladptor=new allpadptr(this,l);
        recyclerView.setAdapter(alladptor);

        b = FirebaseFirestore.getInstance();
        b.collection("ourproducts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                allproducts all = document.toObject(allproducts.class);
                                l.add(all);
                                alladptor.notifyDataSetChanged();
                            }
                        } else {


                        }
                    }
                });



    }
}