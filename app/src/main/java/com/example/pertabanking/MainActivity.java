package com.example.pertabanking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
EditText edtNoreg;
Button btnReg;
Rekening rekening;
String namanya;
String noreg;
ApiInterfaceRekening apiInterfaceRekening;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNoreg=(EditText)findViewById(R.id.edt_noreg);
        btnReg=(Button)findViewById(R.id.btn_reg);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiInterfaceRekening=ApiClientRekening.getApiClient().create(ApiInterfaceRekening.class);
                Call<Rekening> rekeningCall=apiInterfaceRekening.getRekening(edtNoreg.getText().toString());
                rekeningCall.enqueue(new Callback<Rekening>() {
                    @Override
                    public void onResponse(Call<Rekening> call, Response<Rekening> response) {
                        rekening=response.body();
                        String namanya="wiku hermawan";
                        Intent pindah=new Intent(MainActivity.this,BeliActivity.class);
                        pindah.putExtra("namabos",namanya);
                        startActivity(pindah);

                    }

                    @Override
                    public void onFailure(Call<Rekening> call, Throwable t) {
                        Intent pindah=new Intent(MainActivity.this,BeliActivity.class);
                        String namanya="wiku hermawan";
                        pindah.putExtra("namabos",namanya);
                        startActivity(pindah);
                    }
                });
            }
        });
    }
}
