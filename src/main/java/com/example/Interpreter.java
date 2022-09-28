package com.example;
import java.io.*;
import java.net.*;
import java.util.*;



public class Interpreter {
    private String json = null;

    public Interpreter(String url) throws Exception {
        this.json = getHTML(url);
    }

    public String getJSON(){
        return this.json;
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
        String data = this.json;
        data = data.substring(data.indexOf(field + "\":") + (field.length()+2));
        data = data.substring(0, data.indexOf(","));
        return(data);
    }

    private boolean testNested(String field){
        

        return true;
    }
}
