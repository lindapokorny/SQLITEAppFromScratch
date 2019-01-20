package com.example.lindapokorny.sqliteappfromscratch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button submitNewNoteButton;
    private Button viewAllNotesButton;
    Intent intent;

    //1) first we created an empty activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitNewNoteButton = findViewById(R.id.note_submission_button);
        viewAllNotesButton = findViewById(R.id.note_view_button);

        submitNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, EditTextActivity.class);
                startActivity(intent);
            }
        });

        viewAllNotesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, DisplayActivity.class);
                startActivity(intent);
            }
        });
    }

   /*
   This is how to add clicks to our buttons when we add it to the XML
   public void Submit(View view) {
        Intent intent = new Intent(view.getContext(), EditTextActivity.class);
        startActivity(intent);
    }

    public void View(View view) {
        Intent intent = new Intent(view.getContext(), DisplayActivity.class);
        startActivity(intent);
    } */

}
