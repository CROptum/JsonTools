package com.json.tools;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class LoadJSon {
    public static void main(String args[]){
        fromFile();
    }

        public static void fromFile(){
        JSONParser parser = new JSONParser();
        try {

            Object jsonObj = parser.parse(new FileReader("test.json"));

            JSONObject jsonObject = (JSONObject) jsonObj;
            System.out.println(jsonObject);


            String name = (String) jsonObject.get("name");
            System.out.println("name:"+name);

            long age = (Long) jsonObject.get("age");
            System.out.println(age);

            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
