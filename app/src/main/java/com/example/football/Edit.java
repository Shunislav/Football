package com.example.football;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit extends AppCompatActivity {
    EditText input_h, input_g, input_goalh,input_goalg;
    Button add_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        input_h = findViewById(R.id.nameGuest);
        input_g = findViewById(R.id.nameHome);
        input_goalh = findViewById(R.id.etHomePoints);
        input_goalg = findViewById(R.id.etGuestPoints);

        add_button = findViewById(R.id.buttonEdit);

        add_button.setOnClickListener(v -> {
            DBClass mdb = new DBClass(Edit.this);
            mdb.goal(input_h.getText().toString().trim(),
                    input_g.getText().toString().trim(),
                    input_goalh.getText().toString().trim(),
                    input_goalg.getText().toString().trim());
        });

    }

}