package com.example.ecommerceproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Fragment fragmentmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentmain=new Fragmentmain();
        Fragmentattach(fragmentmain);
    }

    private void Fragmentattach(Fragment fragmentmain) {
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frag_m,fragmentmain);
        transaction.commit();


    }
}