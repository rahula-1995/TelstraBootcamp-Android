package com.example.myapplicationi.background;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class DownloadTask extends AsyncTask<String,Integer,Void> { //inputtype, progresstype, resulttype
    ProgressBar mProgressBar;
    public static String TAG = DownloadTask.class.getSimpleName();
    Context mContext;
    public DownloadTask(ProgressBar progressBar, Context context) {
        mProgressBar = progressBar;
        mContext = context;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressBar.setVisibility(View.VISIBLE);
    }

    /**
     * all that you write in this method will execute on a seperate  bg thread
     * @param strings
     * @return
     */
    @Override
    protected Void doInBackground(String... strings) {  //bg thread --- bawarchi--cook
        Log.i(TAG,strings[0]);
        try {

            for(int i=1; i<=20; i++){
                Thread.sleep(100);
                publishProgress(i*5); //5% has been downloaded -- publishprogress will call onProgressUpdate
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        mProgressBar.setVisibility(View.INVISIBLE);
        Toast.makeText(mContext, "food is cooked", Toast.LENGTH_SHORT).show();
    }
}