package com.example.mysqllite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String get = intent.getStringExtra("data");
        TextView texts = findViewById(R.id.myText);
        texts.setText(get);

      /*  String name = intent.getStringExtra("gender");
        String lastName = intent.getStringExtra("name");
        String gender = intent.getStringExtra("lastName");
        String cities = intent.getStringExtra("cityName");


        TextView textView = findViewById(R.id.myText);
        textView.setText(name + "\n" + lastName + "\n" + gender + "\n" + cities);
       */


    }
}