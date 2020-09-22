package com.example.myapplicationi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "logging";
    EditText nameedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         nameedit = findViewById(R.id.editTextTextPersonName);
    }

    public void ClickListener(View view) {
        switch(view.getId()){
            case R.id.button:
                int a=add(10,20);
                Log.i(TAG,"30");
                login();
                break;
            case R.id.button2:
                cancel();
                break;
        }

    }

    private int add(int i, int i1) {
        return i+i1;
    }

    private void cancel() {
        Intent dIntent = new Intent();
        dIntent.setAction(Intent.ACTION_DIAL);
        dIntent.setData( Uri.parse("tel:98765432"));
        startActivity(dIntent);
    }

    private void login() {
        String name=nameedit.getText().toString();
        Toast.makeText(this, "welcome to signin"+name+"to android", Toast.LENGTH_SHORT).show();
        Intent hintent=new Intent(MainActivity.this, HomeActivity.class);
        hintent.putExtra("student",name);
        startActivity(hintent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"mainactivity start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"mainactivity stop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"mainactivity resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"mainactivity pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"mainactivity destroy");
    }


}

