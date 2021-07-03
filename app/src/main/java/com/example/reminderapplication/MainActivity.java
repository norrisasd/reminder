package com.example.reminderapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }
    public void toView(View v){
        Intent i = new Intent(getApplicationContext(),ViewReminder.class);
        startActivity(i);
    }
    public void toCreate(View v){
        Intent i = new Intent(getApplicationContext(),CreateReminder.class);
        startActivity(i);
    }


}