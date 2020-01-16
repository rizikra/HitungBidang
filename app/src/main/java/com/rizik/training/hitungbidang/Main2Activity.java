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

public class Main2Activity extends AppCompatActivity {

    private EditText edtPanjang, edtLebar, edtTinggi;
    private Button btnHitung;
    private TextView tvHasil;
    double volume;
    private final String STATE_HASIL = "state_hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Kenalkan component ke main_activity
        edtPanjang = (EditText) findViewById(R.id.edt_length);
        edtLebar = (EditText) findViewById(R.id.edt_width);
        edtTinggi = (EditText) findViewById(R.id.edt_height);
        btnHitung = (Button) findViewById(R.id.btn_hitung);
        tvHasil = (TextView) findViewById(R.id.tv_hasil);

        getSupportActionBar().setTitle("Volume Balok");
        //berikan action button hitung untuk menghitung hasil
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String panjang, lebar, tinggi;
                panjang = edtPanjang.getText().toString();
                lebar = edtLebar.getText().toString();
                tinggi = edtTinggi.getText().toString();

                boolean isEmptyInput = false;

                if (TextUtils.isEmpty(panjang)){
                    edtPanjang.setError("Harus diisi");
                    edtPanjang.requestFocus();
                    isEmptyInput = true;
                }
                if (TextUtils.isEmpty(lebar)){
                    edtLebar.setError("Harus diisi");
                    edtLebar.requestFocus();
                    isEmptyInput = true;
                }
                if (TextUtils.isEmpty(tinggi)) {
                    edtTinggi.setError("Harus diisi");
                    edtTinggi.requestFocus();
                    isEmptyInput = true;
                }

                    //masukkan rumus
                    double p = Double.parseDouble(panjang);
                    double l = Double.parseDouble(lebar);
                    double t = Double.parseDouble(tinggi);
                    volume = p*l*t;
                    //kemudian hasil ditampilkan di Text View
                    tvHasil.setText(String.valueOf(volume));

            }
        });
        if (savedInstanceState != null){
            volume = savedInstanceState.getDouble(STATE_HASIL);
            tvHasil.setText(String.valueOf(volume));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(STATE_HASIL,volume);
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