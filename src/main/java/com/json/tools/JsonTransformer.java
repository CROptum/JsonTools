package com.json.tools;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Map;
import java.util.Set;

public class JsonTransformer {
    public static void main(String args[]){
        JSONParser parser = new JSONParser();
        try {
            Object jsonObj = parser.parse(new FileReader("procedure.json"));

            JSONObject jsonObject = (JSONObject) jsonObj;
            System.out.println(jsonObject);
            jsonObject = cloneJSon(jsonObject);
            System.out.println(jsonObject);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /*
        Recursive method to clone Json Object
     */
    public static JSONObject cloneJSon(JSONObject inObj) {

        JSONParser parser = new JSONParser();
        JSONObject copyObj = new JSONObject();

        for (Map.Entry<String, Object> entry : (Set<Map.Entry<String, Object>>) inObj.entrySet()) {

            //currently supports String & Long as basic types.. add code for other base types
            if (entry.getValue() instanceof String || entry.getValue() instanceof Long) {
                copyObj.put(entry.getKey(), entry.getValue());

            } else if (entry.getValue() instanceof JSONArray) {
                JSONArray array = new JSONArray();
                for (Object object : (JSONArray) entry.getValue()) {
                    if (object instanceof JSONObject) {
                        array.add(cloneJSon((JSONObject) object));
                    } else {
                        array.add(object);
                    }
                }
                copyObj.put(entry.getKey(), array);
            } else {
                copyObj.put(entry.getKey(), cloneJSon((JSONObject) entry.getValue()));
            }
        }
        return copyObj;
    }


}
