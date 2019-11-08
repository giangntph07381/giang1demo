package com.example.giang1demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btnok;
    TextView tvnam,tvthang,tvngay;
    Calendar chon1a,chon2a;
    SimpleDateFormat simpleDateFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhxa();
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chon1();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chon2();
            }
        });

        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ngay = (int)(chon2a.getTimeInMillis() - chon1a.getTimeInMillis())/(1000*60*60*24);
                tvngay.setText("Ngay :"+ngay);
                int thang = (int)(chon2a.getTimeInMillis() - chon1a.getTimeInMillis())/(1000*60*60*24*30);
                tvthang.setText("Thang :"+thang);
            }
        });

    }
    private void chon1(){
        chon1a = Calendar.getInstance();
        int ngay = chon1a.get(Calendar.DATE);
        int thang = chon1a.get(Calendar.MONTH);
        int nam = chon1a.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog =  new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                chon1a.set(i,i1,i2);
                btn1.setText(simpleDateFormat.format(chon1a.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }

    private void chon2(){
        chon2a = Calendar.getInstance();
        int ngay = chon2a.get(Calendar.DATE);
        int thang = chon2a.get(Calendar.MONTH);
        int nam = chon2a.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog =  new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                chon2a.set(i,i1,i2);
                btn2.setText(simpleDateFormat.format(chon2a.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }

    private void anhxa(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btnok =  findViewById(R.id.btnOK);
        tvnam =  findViewById(R.id.tvnam);
        tvthang =  findViewById(R.id.tvthang);
        tvngay =  findViewById(R.id.tvngay);
    }

}
