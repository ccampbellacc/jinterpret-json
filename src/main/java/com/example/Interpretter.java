package com.example;
import java.io.*;
import java.net.*;
import java.util.*;

public class Interpretter {
    private String json = null;

    public Interpretter(String url) throws Exception {
        this.json = getHTML(url);
    }

    public String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null;) {
                result.append(line);
            }
        }
        return result.toString();
    }

    public String getField(String field) {
        
        return("Working");
    }
}
