package com.example.ecommerceproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.protobuf.StringValue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class informationactivity extends AppCompatActivity {
    ImageView iminfo;
    TextView tvnameinfo,tvpriceinfo;
    private FirebaseFirestore fc;
    FirebaseAuth auth;
    products p=null;
    allproducts s=null;
    Button cart,buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informationactivity);
        iminfo=findViewById(R.id.iminfo);
        tvnameinfo=findViewById(R.id.tvnameinfo);
        tvpriceinfo=findViewById(R.id.tvpriceinfo);
        cart=findViewById(R.id.cart);
        buy=findViewById(R.id.buy);

        fc=FirebaseFirestore.getInstance();
        auth=FirebaseAuth.getInstance();
        final Object o=getIntent().getSerializableExtra("information");
        if(o instanceof products)

        {
            p=(products) o;

        }
        else if(o instanceof allproducts)

        {
            s=(allproducts) o;

        }

        if(p!=null)
        {
            Glide.with(getApplicationContext()).load(p.getImage()).into(iminfo);
            tvnameinfo.setText(p.getName());
            tvpriceinfo.setText(String.valueOf(p.getPrice()));
        }

        if(s!=null)
        {
            Glide.with(getApplicationContext()).load(s.getI()).into(iminfo);
            tvnameinfo.setText(s.getN());
            tvpriceinfo.setText(String.valueOf(s.getP()));
        }
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart();
            }


        });

}

    private void cart() {
        String ctime,cdate;
        Calendar  calendar=Calendar.getInstance();
        SimpleDateFormat cd=new SimpleDateFormat("MM dd,yyyy");
                cdate=cd.format(calendar.getTime());
        SimpleDateFormat ct=new SimpleDateFormat("HH:mm:ss a");
        ctime=ct.format(calendar.getTime());
        final HashMap<String,Object> cartmap=new HashMap<>();
        cartmap.put("productname",tvnameinfo.getText().toString());
        cartmap.put("productprice",tvpriceinfo.getText().toString());
        cartmap.put("currenttime",ctime);
        cartmap.put("currentdate",cdate);
        fc.collection("addtocart").document(auth.getCurrentUser().getUid()).collection("user")
                .add(cartmap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                Toast.makeText(informationactivity.this, "it is added to cart", Toast.LENGTH_SHORT).show();
                finish();
            }

       });





    }
    }