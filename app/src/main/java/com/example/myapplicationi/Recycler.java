package com.example.myapplicationi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Recycler extends AppCompatActivity {
    String[] countries = new String[]{"india","usa","uk"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        RecyclerView country=findViewById(R.id.recyclerview);
        recycleradapter adapter = new recycleradapter(countries,this);
        country.setAdapter(adapter);//17
        country.setLayoutManager(new LinearLayoutManager(this));
    }
}