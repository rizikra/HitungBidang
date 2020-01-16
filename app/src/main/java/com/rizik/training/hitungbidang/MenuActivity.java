package com.rizik.training.hitungbidang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    Button btnPrisma, btnBalok;
    TextView Nama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnPrisma =  findViewById(R.id.btn_vlm_prisma);
        btnBalok = findViewById(R.id.btn_vlm_balok);
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
    }
}
