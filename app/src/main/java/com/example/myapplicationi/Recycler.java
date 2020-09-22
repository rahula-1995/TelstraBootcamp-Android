package com.example.myapplicationi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Recycler extends AppCompatActivity {
    String[] countries = new String[]{"india","usa","uk"};
    String[] state=new String[]{"Bihar","New york","London"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        RecyclerView country=findViewById(R.id.recyclerview);
        recycleradapter adapter = new recycleradapter(countries,state,this);
        country.setAdapter(adapter);//17
        country.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_re,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.settings:
                break;
            case R.id.logout:
                Toast.makeText(this, "logging out", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}