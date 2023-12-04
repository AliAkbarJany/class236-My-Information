package com.rafsan.class236myinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ShowMyInfromation extends AppCompatActivity {

    TextView textName,textFather,textMother,textDate,textNid;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_my_infromation);

        textName = findViewById(R.id.textName);
        textFather = findViewById(R.id.textFather);
        textMother = findViewById(R.id.textMother);
        textDate = findViewById(R.id.textDate);
        textNid = findViewById(R.id.textNid);


        sharedPreferences = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);

        String myName = sharedPreferences.getString("name","");
        String myFatherName = sharedPreferences.getString("fatherName","");
        String myMotherName = sharedPreferences.getString("motherName","");
        String myBirth = sharedPreferences.getString("birth","");

       long myNid = sharedPreferences.getLong("nid", 0);

        textName.setText(myName);
        textFather.setText(myFatherName);
        textMother.setText(myMotherName);
        textDate.setText(myBirth);
        textNid.setText(""+myNid);


    }
}