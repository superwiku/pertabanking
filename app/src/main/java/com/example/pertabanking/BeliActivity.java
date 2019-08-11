package com.example.pertabanking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BeliActivity extends AppCompatActivity {
TextView txtNama, txtBbmnya, txtLiternya;
Button btnPertamax, btnPertalite, btnPertadex, btnOk, btnTransaksi;
EditText edtLiter;
String namadia;
String kodebeli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli);
        txtNama=(TextView)findViewById(R.id.txt_nama);
        txtBbmnya=(TextView)findViewById(R.id.txt_bbm);
        txtLiternya=(TextView)findViewById(R.id.txt_liter);
        btnPertamax=(Button)findViewById(R.id.btn_pertamax);
        btnPertalite=(Button)findViewById(R.id.btn_pertalite);
        btnPertadex=(Button)findViewById(R.id.btn_pertadex);
        btnOk=(Button)findViewById(R.id.btn_ok);
        btnTransaksi=(Button)findViewById(R.id.btn_deal);
        edtLiter=(EditText)findViewById(R.id.edt_liter);
        Intent i=getIntent();
        namadia=i.getStringExtra("namabos");
        txtNama.setText(namadia);
        btnPertamax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtBbmnya.setText("pertamax");
            }
        });
        btnPertalite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtBbmnya.setText("pertalite");
            }
        });
        btnPertadex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtBbmnya.setText("pertadex");
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String literan = edtLiter.getText().toString();
                txtLiternya.setText(literan);
            }
        });

        btnTransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kodebeli=txtNama.getText().toString()+" "+txtBbmnya.getText().toString()+" "+txtLiternya.getText().toString()+" liter";
                Intent bikinkode=new Intent(BeliActivity.this,CodeActivity.class);
                bikinkode.putExtra("kodenya",kodebeli);
                startActivity(bikinkode);
            }
        });


    }
}
