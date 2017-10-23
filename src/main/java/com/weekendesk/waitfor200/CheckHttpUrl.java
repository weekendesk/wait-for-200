package com.weekendesk.waitfor200;

import java.net.HttpURLConnection;
import java.net.URL;

public class CheckHttpUrl {
    private final String url;
    private boolean result;

    public CheckHttpUrl(String url) {
        this.url = url;
    }

    public boolean check() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            this.result = httpURLConnection.getResponseCode() == 200;
        }catch(Exception e) {
            this.result = false;
        }
        return this.result;
    }

    public boolean isAlive() {
        return result;
    }
}
