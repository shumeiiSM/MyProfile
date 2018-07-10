package com.example.a17010233.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        rgGender = findViewById(R.id.RadioGroupGender);

    }

    @Override
    protected void onPause() {
        super.onPause();

        //Step 1a: Get the user input from the EditText and store it in a variable
        String strName = etName.getText().toString();
        float gpa = Float.parseFloat(etGPA.getText().toString());
        int gender = rgGender.getCheckedRadioButtonId();

        //Step 1b: Obtain an instance of the SharedPreferences
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);

        //Step 1c: Obtain an instance of the SharedPreferences Editor for update later
        SharedPreferences.Editor prefEdit = pref.edit();

        //Step 1d: Add the key-value pair
        //         The value should be from the variable defined in Step 1a
        prefEdit.putString("myName", strName);
        prefEdit.putFloat("myGPA", gpa);
        prefEdit.putInt("myGender", gender);

        //Step 1e: Call commit() method to save the changes into SharedPreferences
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Step 2a: Obtain an instance of the SharedPreferences
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);

        //Step 2b: Retrieve the saved data from the SharedPreferences object
        String msg = pref.getString("myName", "No Name!");
        float theGPA = pref.getFloat("myGPA", 0.0f);
        int theGender = pref.getInt("myGender", 0);

        //Step 2c: Update the UI element with the value
        etName.setText(msg);
        etGPA.setText(String.valueOf(theGPA));
        rgGender.check(theGender);
    }





}
