package com.rizik.training.hitungbidang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtPanjang, edtLebar, edtTinggi;
    private Button btnHitung;
    private TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Kenalkan component ke main_activity
        edtPanjang = (EditText) findViewById(R.id.edt_length);
        edtLebar = (EditText) findViewById(R.id.edt_width);
        edtTinggi = (EditText) findViewById(R.id.edt_height);
        btnHitung = (Button) findViewById(R.id.btn_hitung);
        tvHasil = (TextView) findViewById(R.id.tv_hasil);

        getSupportActionBar().setTitle("Hitung Bidang Volume Prisma Segitiga");
        //berikan action button hitung untuk menghitung hasil
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String panjang, lebar, tinggi;
                panjang = edtPanjang.getText().toString();
                lebar = edtLebar.getText().toString();
                tinggi = edtTinggi.getText().toString();

                if (TextUtils.isEmpty(panjang)){
                    edtPanjang.setError("Harus diisi");
                    edtPanjang.requestFocus();
                }
                else if (TextUtils.isEmpty(lebar)){
                    edtLebar.setError("Harus diisi");
                    edtLebar.requestFocus();
                }
                else if (TextUtils.isEmpty(tinggi)) {
                    edtTinggi.setError("Harus diisi");
                    edtTinggi.requestFocus();
                }
                else{
                    //masukkan rumus
                    double p = Double.parseDouble(panjang);
                    double l = Double.parseDouble(lebar);
                    double t = Double.parseDouble(tinggi);
                    double volume = (p * l * t)/2;
                    //kemudian hasil ditampilkan di Text View
                    tvHasil.setText(String.valueOf(volume));
                }
            }
        });
    }

}
