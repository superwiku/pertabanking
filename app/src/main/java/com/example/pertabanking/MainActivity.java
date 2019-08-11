package com.example.pertabanking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
EditText edtNoreg;
Button btnReg;
List<Rekening> rekening;
String namanya;
String noreg;
int noregint;
ApiInterfaceRekening apiInterfaceRekening;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNoreg=(EditText)findViewById(R.id.edt_noregnya);
        btnReg=(Button)findViewById(R.id.btn_reg);
        getClick();
    }

    public void getClick(){

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noreg=edtNoreg.getText().toString();
                noregint=Integer.parseInt(noreg);
                apiInterfaceRekening=ApiClientRekening.getApiClient().create(ApiInterfaceRekening.class);
                Call <List<Rekening>> rekeningCall=apiInterfaceRekening.getRekening(noregint);
                rekeningCall.enqueue(new Callback<List<Rekening>>() {
                    @Override
                    public void onResponse(Call<List<Rekening>> call, Response<List<Rekening>> response) {
                        rekening=response.body();
                        pindah();

                    }

                    @Override
                    public void onFailure(Call<List<Rekening>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });
    }
    public  void pindah(){
        namanya=rekening.get(0).getNama();
        Intent pindah=new Intent(MainActivity.this,BeliActivity.class);
        pindah.putExtra("namabos",namanya);
        startActivity(pindah);
    }
}
