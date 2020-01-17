package com.rizik.training.hitungbidang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    Button btnPrisma, btnBalok, btnTabung, btnContactUs, btnWeb;
    TextView Nama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnPrisma =  findViewById(R.id.btn_vlm_prisma);
        btnBalok = findViewById(R.id.btn_vlm_balok);
        btnTabung = findViewById(R.id.btn_vlm_tabung);
        btnContactUs = findViewById(R.id.btn_contact_us);
        btnWeb = findViewById(R.id.btn_web);
        Nama = findViewById(R.id.tv_name);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            Nama.setText("Hallo "+bundle.getString( "nama"));
            Nama.setVisibility(View.VISIBLE);
        }


        btnPrisma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PindahPrisma = new Intent(MenuActivity.this,MainActivity.class);
                startActivity(PindahPrisma);
            }
        });

        btnBalok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PindahBalok = new Intent(MenuActivity.this,Main2Activity.class);
                startActivity(PindahBalok);
            }
        });

        btnTabung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PindahTabung = new Intent(MenuActivity.this,Main3Activity.class);
                startActivity(PindahTabung);
            }
        });

        btnContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomorHp = "083898719062";
                Uri tel = Uri.parse ("tel:" +nomorHp);
                Intent dialContact = new Intent(Intent.ACTION_DIAL, tel);
                startActivity (dialContact);
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String web = "www.instagram.com/rizikizir/";
                Uri domain = Uri.parse("http://" +web);
                Intent openWeb = new Intent(Intent.ACTION_VIEW, domain);

                //buat pilihan untuk memilih browser yg digunakan
                Intent chooser = Intent.createChooser(openWeb, "Complete Action Using :");
                if(openWeb.resolveActivity(getPackageManager()) != null){
                    startActivity(chooser);
                }
            }
        });
    }
}

