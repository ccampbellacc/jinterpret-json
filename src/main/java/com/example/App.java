package com.example;

import java.io.*;
import java.net.*;
import java.util.*;

import com.google.gson.Gson;

/**
 * https://api.opendota.com/api/players/294548916
 *
 */
public class App {

    public static void main(String[] args) throws Exception {
        String data = getHTML("https://api.opendota.com/api/players/294548916");
        data = data.substring(data.indexOf("solo_competitive_rank\":") + 23);
        data = data.substring(0, data.indexOf(","));
        System.out.println("Colin MMR: " + data);
    }
}
