package com.example.reminderapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.List;


public class ViewReminder extends AppCompatActivity {
    ListView reminderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reminder);
        getSupportActionBar().hide();
        reminderList = (ListView)findViewById(R.id.lv);
        display(this.findViewById(android.R.id.content));
        reminderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Reminder r = (Reminder) parent.getItemAtPosition(position);
                DBHelper dbh = new DBHelper(getApplicationContext());
                boolean check = dbh.deleteReminder(r);
                if(!check){
                    Toast.makeText(getApplicationContext(),"Reminder Deleted",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"There was an Error!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void back(View v){
        finish();
    }
    public void display(View v){
        DBHelper dbh = new DBHelper(getApplicationContext());
        List<Reminder> display = dbh.displayReminders();
        ArrayAdapter ad = new ArrayAdapter<Reminder>(getApplicationContext(),R.layout.activity_main,display);
        reminderList.setAdapter(ad);




        //----------------------------------- to change the text color of list view to white-----------------------
        ArrayAdapter<Reminder> adapter=new ArrayAdapter<Reminder>(
                this, android.R.layout.simple_list_item_1, display){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);

                TextView textView=(TextView) view.findViewById(android.R.id.text1);

                /*YOUR CHOICE OF COLOR*/
                textView.setTextColor(Color.WHITE);

                return view;
            }
        };
        /*SET THE ADAPTER TO LISTVIEW*/
        reminderList.setAdapter(adapter);
        //--------------------------------------------------------------------------------------------------------
    }
}