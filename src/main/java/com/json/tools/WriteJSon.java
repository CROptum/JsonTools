package com.json.tools;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class WriteJSon {

    public static void main(String args[]){
        toFile();
    }
    public static void toFile(){
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "Alex");
        jsonObj.put("age", new Integer(30));

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        jsonObj.put("messages", list);

        try  {
            FileWriter file = new FileWriter("test.json");

            file.write(jsonObj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
