package com.rafsan.class236myinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editName,editFather,editMother,editBirth,editNID;

    Button buttonSavaData,buttonCheckNID;


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editFather = findViewById(R.id.editFather);
        editMother = findViewById(R.id.editMother);
        editBirth = findViewById(R.id.editBirth);
        editNID = findViewById(R.id.editNID);

        buttonSavaData = findViewById(R.id.buttonSavaData);
        buttonCheckNID = findViewById(R.id.buttonCheckNID);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        editor = sharedPreferences.edit();

        //==================== Save Data=========================

        buttonSavaData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editName.getText().toString();
                String fatherName = editFather.getText().toString();
                String motherName = editMother.getText().toString();
                String birth = editBirth.getText().toString();

                String nid = editNID.getText().toString();
                long int_nid = Long.parseLong(nid);

                editor.putString("name",""+name);
                editor.putString("fatherName", ""+fatherName);
                editor.putString("motherName", ""+motherName);
                editor.putString("birth",""+birth);
                editor.putLong("nid",int_nid);

                editor.apply();

            }
        });

        buttonCheckNID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,ShowMyInfromation.class));

            }
        });


    }
}