package com.example.undraitytelabaratorinis4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvContent;
    ArrayAdapter listAdapter;
    ArrayList<String> fullResult;
    ListView lvExchangeRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvContent = findViewById(R.id.tvContent);
    }

    public void onBtnDownloadClick(View view) {
        this.tvContent.setText("Exchange rates from ECB:");
        new DataLoader(){
            @Override
            public void onPostExecute(List<String> result)
            {
                lvExchangeRate= findViewById(R.id.lvExchangeRate);
                fullResult= new ArrayList<String>(result);
                listAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, fullResult);
                lvExchangeRate.setAdapter(listAdapter);
            }
        }.execute();
    }
}