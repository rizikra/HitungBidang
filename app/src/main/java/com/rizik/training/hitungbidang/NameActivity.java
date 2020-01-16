package com.rizik.training.hitungbidang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {
    private Button btnNext;
    private EditText edtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        btnNext = (Button) findViewById(R.id.btn_next);
        edtName = (EditText) findViewById(R.id.edt_nama) ;

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtName.length() == 0){
                    edtName.setError("Harus diisi");
                }
                else{

                    Intent PindahHitungBidang = new Intent (NameActivity.this,MenuActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("nama", edtName.getText().toString());
                    PindahHitungBidang.putExtras(bundle);
                    startActivity(PindahHitungBidang);
                }
            }
        });
    }
}
