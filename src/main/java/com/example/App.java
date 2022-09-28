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
        Interpreter interpreter = new Interpreter("https://api.opendota.com/api/players/294548916");
        String jsonData = interpreter.getJSON();
        int fieldAt = jsonData.indexOf("\"profile\"");
        ArrayList<Integer> openers = new ArrayList<Integer>();
        Integer index = jsonData.indexOf("{");
        while (index != -1) {
            openers.add(index);
            index = jsonData.indexOf("{", index + 1);
        }
        System.out.println(fieldAt);
        System.out.println(openers);
        System.out.println(findClosestAbove(openers, fieldAt));
    }

    public static Integer findClosestAbove(ArrayList<Integer> arr, int target) {
        Integer min = null;

        for (Integer x : arr) {
            if (x != null && x > target && (min == null || min > x)) {
                min = x;
            }
        }
        return min; // may be null
    }
}
