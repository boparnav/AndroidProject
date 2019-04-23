package com.example.androidproject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private  EditText et1;
    private  EditText et2;

    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> description = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.name);

        et2 = (EditText)findViewById(R.id.des);



        onCall();
    }


    public void addUser (View v)
    {


        names.add(et1.getText().toString());

        description.add(et2.getText().toString());

        DBhelper dbh = new DBhelper(this);

        boolean result = dbh.addUser(et1.getText().toString() , et2.getText().toString());

        onCall();

        if (result)
        {
            Toast.makeText(this, "Successfully" , Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "UnSuccessfully" , Toast.LENGTH_SHORT).show();
        }

    }



    public  void onCall()
    {

        final ArrayList<String> userDataFromDBname = new ArrayList<>();
        final ArrayList<String> userDataFromDBdescription = new ArrayList<>();
        final ArrayList<Integer> userDataFromDBId = new ArrayList<>();


        DBhelper dbh = new DBhelper(this);
        Cursor data = dbh.getData();

        while(data.moveToNext())
        {
            userDataFromDBname.add(data.getString(1));
            userDataFromDBdescription.add(data.getString(2));
            userDataFromDBId.add(data.getInt(0));
        }


        CustomAdapter ca = new CustomAdapter(this, userDataFromDBname ,userDataFromDBdescription);

        ListView lt = (ListView)findViewById(R.id.list);

        lt.setAdapter(ca);




        lt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                onCall();

                Intent profile = new Intent(MainActivity.this , ProfileLayout.class);

                profile.putExtra("name", userDataFromDBname.get(position) );
                profile.putExtra("desc" , userDataFromDBdescription.get(position));
                profile.putExtra("id" , userDataFromDBId.get(position).toString());

                startActivity(profile);
            }
        });
    }
}