package com.example.myapplicationi;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationi.background.DownloadTask;

public class AsyncActivity extends AppCompatActivity {


    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

    }

        public void taskClick(android.view.View view) {
            DownloadTask downloadTask = new DownloadTask(progressBar,this);
            downloadTask.execute("www.imageurltobedowloaded.com");
        }

    }
