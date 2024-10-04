package com.example.mad_projects;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    EditText editText;
    Button celsius,meter,grams,back,dollar,nepal,vietnam,euro;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        editText = findViewById(R.id.input);
        celsius = findViewById(R.id.cel);
        meter = findViewById(R.id.met);
        grams = findViewById(R.id.gra);
        back = findViewById(R.id.back);
        result = findViewById(R.id.res);
        dollar = findViewById(R.id.dol);
        nepal = findViewById(R.id.nep);
        vietnam = findViewById(R.id.viet);
        euro = findViewById(R.id.eur);

            celsius.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String us =editText.getText().toString();
                    double celsius = Double.parseDouble(us);
                    double fahrenheit = (celsius* 9/5 ) +32 ;
                    //for result
                    result.setText("Result : "+fahrenheit +"°F");
                }
            });
            meter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String us = editText.getText().toString();
                    double meter = Double.parseDouble(us);
                    double kilometer = meter/1000.0;
                    result.setText("Result :"+kilometer+"KM");
                }
            });


            grams.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String us = editText.getText().toString();
                    double gram = Double.parseDouble(us);
                    double pounds = gram*0.00220462;
                    result.setText(" grams is equal to " + pounds + " pounds.");
                }
            });

            dollar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String us = editText.getText().toString();
                    double indianRupee = Double.parseDouble(us);
                    double USDollar = indianRupee*0.012;
                    result.setText("indianRupee is equal to" + USDollar + "United States Dollar");
                }
            });
            nepal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String us = editText.getText().toString();
                    double indianRupee = Double.parseDouble(us);
                    double NepalCurrency = indianRupee*1.60;
                    result.setText("indianRupee is equal to"+NepalCurrency+ "Nepalese Rupee");
                }
            });
            vietnam.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String us = editText.getText().toString();
                    double indianRupee = Double.parseDouble(us);
                    double  Vietnamesedong = indianRupee*294.74;
                    result.setText("indianRupee is equal to"+Vietnamesedong + "Vietnamesedong");
                }
            });
            euro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String us = editText.getText().toString();
                    double indianRupee = Double.parseDouble(us);
                    double Euros = indianRupee*0.011;
                    result.setText("indianRupee is equal to:" +Euros+"Euro");
                }
            });

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity2.this,secondActivity.class);
                    startActivity(i);
                }
            });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}