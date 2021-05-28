package com.example.undraitytelabaratorinis4;
import android.os.AsyncTask;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class DataLoader extends AsyncTask<String, Void, List<String>> {

    protected List<String> doInBackground(String... params) {
        try {
            return DataManager.getRateFromECB();
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            return new ArrayList<>(List.of(sw.toString() ));
        }
    }
}