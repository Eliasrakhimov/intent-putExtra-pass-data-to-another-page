package com.example.mysqllite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    private Button submitButton;
    private RadioButton male, female;
    public RadioGroup mGroup;
    private EditText name, lastName;
    private CheckBox mCheckBox;
    private String genders, cities;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] cityName = {"Tashkent", "Moscow", "Madrid", "Edmonton", "Toronto"};

        submitButton = findViewById(R.id.submitButton);
        male = findViewById(R.id.maleGender);
        female = findViewById(R.id.femaleGender);
        name = findViewById(R.id.name);
        lastName = findViewById(R.id.lastName);
        mCheckBox = findViewById(R.id.checks);
        Spinner spinner = findViewById(R.id.citiesSpinner);
        mGroup = findViewById(R.id.radioGroups);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, cityName);
        spinner.setAdapter(arrayAdapter);
        
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cities = cityName[i];
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mCheckBox.setOnCheckedChangeListener((compoundButton, b) -> submitButton.setEnabled(mCheckBox.isChecked()));

        mGroup.setOnCheckedChangeListener((radioGroup, i) -> {
            if (male.isChecked()) genders = "male";
            else if (female.isChecked()) genders = "female";
        });


        submitButton.setOnClickListener(view -> {

            Intent intent = new Intent(this, MainActivity2.class);
            UserData data = UserData.getUserData(name.getText().toString(),
                            lastName.getText().toString(), genders, cities);
            intent.putExtra("data", String.valueOf(data));
            startActivity(intent);

        });

    }

}