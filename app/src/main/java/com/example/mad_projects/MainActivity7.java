package com.example.mad_projects;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity7 extends AppCompatActivity {
    EditText username, password;
    Button login, Register;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main7);

        username = findViewById(R.id.user);
        password = findViewById(R.id.pass);
        login = findViewById(R.id.log);
        Register = findViewById(R.id.reg);

        DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("dipak_22k") || pass.equals("dipak@123")) {
                    Toast.makeText(MainActivity7.this, "Login successful", Toast.LENGTH_SHORT).show();

                } else {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if (checkuserpass) {
                        Toast.makeText(MainActivity7.this, "Login Successful", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(MainActivity7.this, "INVALID - CREDENTIALS", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity7.this, MainActivity8.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



}
