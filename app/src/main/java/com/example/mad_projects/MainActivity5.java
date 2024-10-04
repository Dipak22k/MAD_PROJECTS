package com.example.mad_projects;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity5 extends AppCompatActivity {
    private EditText editTextDisplay;
    private double firstValue = 0;
    private String operation = "";
            Button backto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);

        editTextDisplay = findViewById(R.id.editTextDisplay);
        backto = findViewById(R.id.back);

        backto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity5.this,secondActivity.class);
                startActivity(intent);
            }
        });

        int[] numberButtons = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
                R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};

        View.OnClickListener numberListener = view -> {
            Button button = (Button) view;
            editTextDisplay.append(button.getText().toString());
        };
        for (int id : numberButtons) {
            findViewById(id).setOnClickListener(numberListener);
        }
        int[] operationButtons = {R.id.buttonAdd, R.id.buttonSubtract, R.id.buttonMultiply, R.id.buttonDivide};


        View.OnClickListener operationListener = view -> {
            Button button = (Button) view;
            firstValue = Double.parseDouble(editTextDisplay.getText().toString());
            operation = button.getText().toString();
            editTextDisplay.setText("");
        };
        for (int id : operationButtons) {
            findViewById(id).setOnClickListener(operationListener);
        }

        findViewById(R.id.buttonEqual).setOnClickListener(view -> {
            double secondValue = Double.parseDouble(editTextDisplay.getText().toString());
            double result = 0;

            switch (operation) {
                case "+":
                    result = firstValue + secondValue;
                    break;
                case "-":
                    result = firstValue - secondValue;
                    break;
                case "*":
                    result = firstValue * secondValue;
                    break;
                case "/":
                    if (secondValue != 0) {
                        result = firstValue / secondValue;
                    } else {
                        editTextDisplay.setText("Error");
                        return;
                    }
                    break;
            }
            editTextDisplay.setText(String.valueOf(result));
        });
        findViewById(R.id.buttonClear).setOnClickListener(view -> {
            editTextDisplay.setText("");
            firstValue = 0;
            operation = "";
        });
    }
}


