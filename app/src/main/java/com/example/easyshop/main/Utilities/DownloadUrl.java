package com.example.easyshop.main.Utilities;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadUrl {

    public String retrieveUrl(String url) throws IOException {
        String urlData = "";
        InputStream inputStream = null;
        HttpURLConnection urlConnection = null;

        try {
            URL getUrl = new URL(url);
            urlConnection = (HttpURLConnection) getUrl.openConnection();
            urlConnection.connect();

            inputStream = urlConnection.getInputStream();
            Log.d("", "INPUT STREAM" + inputStream.toString());
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer sb = new StringBuffer();

            String line = "";
            while((line = br.readLine()) != null) {
                sb.append(line);
            }

            urlData = sb.toString();
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                inputStream.close();
            urlConnection.disconnect();
        }

        return urlData;
    }
}
