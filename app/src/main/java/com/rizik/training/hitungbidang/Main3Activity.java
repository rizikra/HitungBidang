package com.rizik.training.hitungbidang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private EditText edtJari2, edtTinggi;
    private Button btnHitung;
    private TextView tvHasil;
    double volume;
    double phi = 3.14285714286;
    private final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //Kenalkan component ke main_activity
        edtJari2 = (EditText) findViewById(R.id.edt_jari);
        edtTinggi = (EditText) findViewById(R.id.edt_height);
        btnHitung = (Button) findViewById(R.id.btn_hitung);
        tvHasil = (TextView) findViewById(R.id.tv_hasil);

        getSupportActionBar().setTitle("Volume Tabung");
        //berikan action button hitung untuk menghitung hasil
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jari2, tinggi;
                jari2 = edtJari2.getText().toString();
                tinggi = edtTinggi.getText().toString();

                boolean isEmptyInput = false;

                if (TextUtils.isEmpty(jari2)){
                    edtJari2.setError("Harus diisi");
                    edtJari2.requestFocus();
                    isEmptyInput = true;
                }
                if (TextUtils.isEmpty(tinggi)) {
                    edtTinggi.setError("Harus diisi");
                    edtTinggi.requestFocus();
                    isEmptyInput = true;
                }

                if(!isEmptyInput) {
                    //masukkan rumus
                    phi = 3.14285714286;
                    double r = Double.parseDouble(jari2);
                    double t = Double.parseDouble(tinggi);
                    volume = phi*r*r*t;
                    //kemudian hasil ditampilkan di Text View
                    tvHasil.setText(String.valueOf(volume));
                }
            }
        });
        if (savedInstanceState != null){
            volume = savedInstanceState.getDouble(STATE_RESULT);
            tvHasil.setText(String.valueOf(volume));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(STATE_RESULT,volume);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}