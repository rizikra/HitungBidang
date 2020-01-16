package com.rizik.training.hitungbidang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtPanjang, edtLebar, edtTinggi;
    private Button btnHitung;
    private TextView tvHasil;
    double volume;
    private final String STATE_HASIL = "state_hasil";

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

        if (savedInstanceState != null) {
            volume = savedInstanceState.getDouble(STATE_HASIL);
            Log.i("V:",String.valueOf(volume));
            tvHasil.setText(String.valueOf(volume));
        }

        getSupportActionBar().setTitle("Volume Prisma Segitiga");
        //berikan action button hitung untuk menghitung hasil
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String panjang, lebar, tinggi;
                panjang = edtPanjang.getText().toString().trim();
                lebar = edtLebar.getText().toString().trim();
                tinggi = edtTinggi.getText().toString().trim();
                boolean isEmptyInput = false;
                boolean isValidDouble = true;
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
                    Double p = convertToDouble(panjang); // null adalah invalid Double
                    Double l = convertToDouble(lebar);
                    Double t = convertToDouble(tinggi);

                    if(p == null){
                        isValidDouble = false;
                    }

                    if(l == null){
                        isValidDouble = false;
                    }

                    if(t == null){
                        isValidDouble =false;
                    }
                    if(!isEmptyInput && isValidDouble) {
                        volume = (p * l * t) / 2;
                        //kemudian hasil ditampilkan di Text View
                        tvHasil.setText(String.valueOf(volume));
                    }
                }
            });
        }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(STATE_HASIL, volume);
    }

    private Double convertToDouble(String data){
        try{
            Double newData = Double.valueOf(data);
            return newData;
        }
        catch (Exception e){
            return null;
        }
    }

    //untuk klik kembali di bar supaya keterangan nama tidak hilang
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


