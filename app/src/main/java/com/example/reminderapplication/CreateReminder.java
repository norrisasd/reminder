package com.example.reminderapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateReminder extends AppCompatActivity {
    EditText date,time,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_reminder);
        getSupportActionBar().hide();
        date = (EditText)findViewById(R.id.Date);
        time = (EditText)findViewById(R.id.Time);
        description=(EditText)findViewById(R.id.Description);
    }
    public void back(View v){
        finish();
    }
    public void createReminder(View v){
        DBHelper dbh = new DBHelper(getApplicationContext());
        Reminder r = new Reminder(-1,date.getText().toString(),time.getText().toString(),description.getText().toString());
        boolean check = dbh.createReminder(r);
        if(check){
            Toast.makeText(getApplicationContext(),"Reminder Created",Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(getApplicationContext(),"There was an Error!",Toast.LENGTH_SHORT).show();
        }

    }
}