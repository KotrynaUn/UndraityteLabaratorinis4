package com.example.undraitytelabaratorinis4;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class DataManager {

    public static List<String> getRateFromECB() throws IOException {
        List<String> fullResult = new ArrayList<>(List.of("Data were not retrieved" ));
        InputStream stream = downloadUrl(Constants.ECB_URL);
        try {
            fullResult = XmlParser.getRateFromECB(stream);
        }
        finally {
            if (stream != null) {
                stream.close();
            }
        }
        return fullResult;
    }

    private static InputStream downloadUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.connect();
        return conn.getInputStream();
    }
}
