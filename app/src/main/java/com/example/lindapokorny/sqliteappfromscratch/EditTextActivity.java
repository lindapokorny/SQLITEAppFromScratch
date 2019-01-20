package com.example.lindapokorny.sqliteappfromscratch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lindapokorny.sqliteappfromscratch.database.NoteDataBase;
import com.example.lindapokorny.sqliteappfromscratch.model.Note;

public class EditTextActivity extends AppCompatActivity {

    private EditText nameEdit;
    private EditText messageEdit;
    private Button submitNoteButton;
    private NoteDataBase noteDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        nameEdit = findViewById(R.id.name_input);
        messageEdit = findViewById(R.id.message_input);
        submitNoteButton = findViewById(R.id.submit_edit_text_button);
        noteDataBase = NoteDataBase.getInstance(getApplicationContext());

        submitNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String name = nameEdit.getText().toString();
                    String message = messageEdit.getText().toString();
                    Note note = new Note(name, message);
                    noteDataBase.addNote(note);
                }catch (Exception e){
                    e.printStackTrace();

                }
                for (int i = 0; i < noteDataBase.getNoteList().size(); i++) {
                    Log.d("DataBaseRow: ", "Name: " + noteDataBase.getNoteList().get(i).getName());
                    Log.d("DataBaseRow2", "message" + noteDataBase.getNoteList().get(i).getMessage());
                }
                Toast.makeText(getApplicationContext(), "Data Added", Toast.LENGTH_SHORT).show();
            }
        });
    }


//   // public void SubmitNote(View view) {
//    }
}
