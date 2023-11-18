package com.example.assignment1_eyas;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class TasksActivity extends AppCompatActivity {

    TextView tx_name,tx_date,tx_note;
    Switch s_switch;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        Intent intent = getIntent();
        tx_name = findViewById(R.id.tx_name);
        tx_date = findViewById(R.id.tx_date);
        tx_note = findViewById(R.id.tx_note);
        s_switch = findViewById(R.id.tx_switch);
        //tx.setBackgroundColor(Color.parseColor("#FFFAB0"));
        String name =(String) intent.getExtras().get("task_name");
        String date =(String) intent.getExtras().get("task_date");
        String note =(String) intent.getExtras().get("task_note");
        Byte status = (Byte) intent.getExtras().get("task_status");
        int pos = (int) intent.getExtras().get("pos");
        tx_name.setText(name);
        tx_date.setText(date);
        tx_note.setText(note);

        if(status==1)
            s_switch.setChecked(true);
        else
            s_switch.setChecked(false);



        back= findViewById(R.id.back);
        back.setOnClickListener( v -> {
            int done;
            if(s_switch.isChecked())
                done=1;
            else {
                done = 0;
            }
            Intent intent1 = new Intent(TasksActivity.this, MainActivity.class);
            intent1.putExtra("status",done);
            intent1.putExtra("pos",pos);
            startActivity(intent1);
        });

    }
}
