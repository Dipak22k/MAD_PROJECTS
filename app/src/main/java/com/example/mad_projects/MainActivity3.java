package com.example.mad_projects;

import java.util.ArrayList;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.graphics.Insets;

public class MainActivity3 extends AppCompatActivity {
    private EditText editTextName, editTextRollNumber, editTextGrade;
    private Button buttonAdd, button;
    private ListView listViewStudents;
    private ArrayList<Student> studentList;
    private ArrayAdapter<Student> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Ensure EdgeToEdge is implemented correctly
        setContentView(R.layout.activity_main3);

        // Initialize views
        button = findViewById(R.id.BacktoLogin);
        editTextName = findViewById(R.id.editTextName);
        editTextRollNumber = findViewById(R.id.editTextRollNumber);
        editTextGrade = findViewById(R.id.editTextGrade);
        buttonAdd = findViewById(R.id.buttonAdd);
        listViewStudents = findViewById(R.id.listViewStudents);

        // Initialize student list and adapter
        studentList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentList);
        listViewStudents.setAdapter(adapter);

        // Set up button click listeners
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStudent();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, secondActivity.class);
                startActivity(intent);

            }
        });

        // Apply window insets for padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addStudent() {
        // Get text from EditText fields
        String name = editTextName.getText().toString().trim();
        String rollNumber = editTextRollNumber.getText().toString().trim();
        String grade = editTextGrade.getText().toString().trim();

        // Check for empty fields
        if (!name.isEmpty() && !rollNumber.isEmpty() && !grade.isEmpty()) {
            Student student = new Student(name, rollNumber, grade);
            studentList.add(student);
            adapter.notifyDataSetChanged();
            Log.d("MainActivity3", "Added Student: " + student.toString());
            clearFields();
        } else {
            Log.d("MainActivity3", "Empty fields, student not added.");
        }
    }

    private void clearFields() {
        // Clear input fields
        editTextName.setText("");
        editTextRollNumber.setText("");
        editTextGrade.setText("");
    }
}
