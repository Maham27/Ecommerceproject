package com.example.ecommerceproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class Fragmentmain extends Fragment {

    RecyclerView.LayoutManager layoutManager;
       RecyclerView listrecyler;
       itemsadaptor itadaptor;
       List<itemsnames> itnames;
       FirebaseFirestore fb;
    RecyclerView precyler;
    productsadaptor padaptor;
    List<products> pnames;




    public Fragmentmain() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View w=inflater.inflate(R.layout.fragment_fragmentmain, container, false);

        ImageSlider im=w.findViewById(R.id.image_slider);
        List<SlideModel> sm=new ArrayList<>();
        sm.add(new SlideModel(R.drawable.dis,"discount", ScaleTypes.CENTER_CROP));
        sm.add(new SlideModel(R.drawable.disclothes,"discount", ScaleTypes.CENTER_CROP));
        sm.add(new SlideModel(R.drawable.disbags,"discount", ScaleTypes.CENTER_CROP));

        im.setImageList(sm);



        listrecyler=w.findViewById(R.id.collection);
        precyler=w.findViewById(R.id.ourproducts);
       // listrecyler.setHasFixedSize(true);
        //listrecyler.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));




        fb = FirebaseFirestore.getInstance();
        fb.collection("list")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                           for (QueryDocumentSnapshot document : task.getResult()) {
                               itemsnames itname = document.toObject(itemsnames.class);
                              itnames.add(itname);
                                itadaptor.notifyDataSetChanged();
                            }
                        } else {

                            Toast.makeText(getActivity(), ""+task.getException(), Toast.LENGTH_SHORT).show();

                       }
                    }
                });
        fb = FirebaseFirestore.getInstance();
        fb.collection("NewProducts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                products pname = document.toObject(products.class);
                                pnames.add(pname);
                                padaptor.notifyDataSetChanged();
                            }
                        } else {

                            Toast.makeText(getActivity(), ""+task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

        listrecyler.setLayoutManager(new GridLayoutManager(getActivity(),2,RecyclerView.VERTICAL,false));
        itnames = new ArrayList<>();
        //itnames.add(new itemsnames("menshoes", "Men shoes", "shoes"));
        //itnames.add(new itemsnames("bagp", "Bags", "bags"));
        //itnames.add(new itemsnames("menkurta", "Men clothes", "kurta"));
        itadaptor=new itemsadaptor(getContext(),itnames);
        listrecyler.setAdapter(itadaptor);

        precyler.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        pnames = new ArrayList<>();
        //pnames.add(new products("menshoes", "fs1", 250));
        padaptor=new productsadaptor(getContext(),pnames);
        precyler.setAdapter(padaptor);

         return w;
    }
}

