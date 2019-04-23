package com.example.androidproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    //String[] names;
    //String[] description ;
    Context context;
    LayoutInflater inflater;
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> description = new ArrayList<String>();

    public CustomAdapter(Context appContext, ArrayList<String> rName, ArrayList<String> rDesc ){

        this.names= rName;
        this.description= rDesc;
        this.context = appContext;
        this.inflater = inflater.from(appContext);

    }


    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        convertView = inflater.from (context).inflate(R.layout.activity_my_list,null);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView desc = (TextView) convertView.findViewById(R.id.desc);


        name.setText(names.get(position));
        desc.setText(description.get(position));


        return convertView;
    }
}