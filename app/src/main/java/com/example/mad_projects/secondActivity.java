package com.example.mad_projects;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class secondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
        Button convert,studentdb,internalIntent,calculator,intents,Sql,back;

        convert = findViewById(R.id.converter);
        studentdb = findViewById(R.id.studentDb);
        internalIntent = findViewById(R.id.internalIntent);
        calculator = findViewById(R.id.calculator);
        intents = findViewById(R.id.intent);
        Sql = findViewById(R.id.usingSQL);
        back = findViewById(R.id.back);
        // Optionally, you can display a message or user info here
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(secondActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        studentdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(secondActivity.this,MainActivity3.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(secondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        internalIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(secondActivity.this,MainActivity4.class);
                startActivity(intent);
            }
        });

        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(secondActivity.this ,MainActivity5.class);
                startActivity(intent);
            }
        });

        intents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent internalintent = new Intent(secondActivity.this,MainActivity6.class);
                    startActivity(internalintent);
            }
        });


        Sql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(secondActivity.this, MainActivity7.class);
                startActivity(intent);
            }
        });






}
}
