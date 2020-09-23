package com.example.myapplicationi.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.example.myapplicationi.database.FeedReaderContract.FeedEntry;

import com.example.myapplicationi.R;


public class DbActivity extends AppCompatActivity {
    private static final String TAG = "logging";
    EditText titleET,subtitleET;
    Dao dao;
    ListView dbListView;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        titleET = findViewById(R.id.titleEdittext);
        subtitleET = findViewById(R.id.subtitleedittext);
        dao = new Dao(this);
        dao.openDb();

        Cursor dataCursor =  dao.readRows();

        dbListView = findViewById(R.id.dblist);
        Uri uriSms = Uri.parse("content://sms/inbox");

        Cursor c = getContentResolver().query(uriSms, null,null,null,null);
        Log.i(TAG, "on1");
        CursorAdapter adapter = new SimpleCursorAdapter(DbActivity.this,
                android.R.layout.simple_list_item_1,  //layout
                c, //data
                new String[]{"body"},

                //ContactsContract.Contacts.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER},
                //FeedEntry.COLUMN_NAME_TITLE,FeedEntry.COLUMN_NAME_SUBTITLE},// from column names
                new int[]{android.R.id.text1}); ///to these 2 textviews
        Log.i(TAG, "on2");
        dbListView.setAdapter(adapter);

    }




    public void handleDbClicks(View view) {
        switch (view.getId()){
            case R.id.buttonput:
                putDb();
                break;
            case R.id.buttonget:
                getDb();
                break;
        }
    }

    private void getDb() {
        String result = dao.readRow();
        TextView resultTextView = findViewById(R.id.textViewdb);
        resultTextView.setText(result);
    }

    //test case -- open db and see the data
    private void putDb() {
        String title = titleET.getText().toString();
        String subtitle = subtitleET.getText().toString();
        dao.createRow(title,subtitle);
    }
}