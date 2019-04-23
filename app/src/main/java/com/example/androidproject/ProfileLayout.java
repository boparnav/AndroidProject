package com.example.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileLayout extends AppCompatActivity {

    private TextView na;
    private TextView des;
    public int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_layout);

         na = (TextView)findViewById(R.id.txtName);

        des = (TextView)findViewById(R.id.txtDesc);

        String name1 = getIntent().getStringExtra("name");

        String descri = getIntent().getStringExtra("desc");
        String str_id =getIntent().getStringExtra("id");
        this.id = Integer.parseInt(str_id);

        na.setText(name1);
        des.setText(descri);
    }

    public void onClick(View v)
    {
        DBhelper dbH = new DBhelper(this);

        dbH.deleteData(id);

        Toast.makeText(this, "Successfully Done" , Toast.LENGTH_SHORT).show();

        Intent mainPageIntent = new Intent(this, MainActivity.class);

        startActivity(mainPageIntent);

    }
}
