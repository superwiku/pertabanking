package com.example.pertabanking;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class CodeActivity extends AppCompatActivity {
    TextView txtKodeBeli;
    ImageView imgCode;
    Button tampilkanKode;
    String kodescan;
    MultiFormatWriter multi=new MultiFormatWriter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        txtKodeBeli=(TextView)findViewById(R.id.txt_kodebeli);
        imgCode=(ImageView)findViewById(R.id.img_code);
        Intent a=getIntent();
        txtKodeBeli.setText(a.getStringExtra("kodenya"));
        tampilkanKode=(Button)findViewById(R.id.btn_tampil);
        tampilkanKode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    kodescan=txtKodeBeli.getText().toString();
                    BitMatrix bitMatrix=multi.encode(kodescan, BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder encoder=new BarcodeEncoder();
                    Bitmap bitmap=encoder.createBitmap(bitMatrix);
                    imgCode.setImageBitmap(bitmap);
                }catch (WriterException e){
                    e.printStackTrace();
                }
            }
        });

    }

}
