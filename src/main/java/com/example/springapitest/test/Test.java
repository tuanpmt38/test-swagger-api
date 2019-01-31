package com.example.springapitest.test;

import com.example.springapitest.utils.ConnectApi;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        ResponseEntity<String> response = ConnectApi.httpRequest("https://apix.shippo.vn/config/location/9");
        String result = response.getBody();
        System.out.println("------> " + result);

        JSONObject json = new JSONObject(result);
        Integer parentId = json.getJSONObject("result").getInt("parent_id");
        String namePath = json.getJSONObject("result").getString("name");
        String state = json.getJSONObject("result").getString("state");


        Map<Integer, String> hmap = new HashMap<Integer, String>();
        hmap.put(1, "Java");
        hmap.put(2, "Javascript");
        hmap.put(3, "PHP");
        hmap.put(4, "C#");
        hmap.put(5, "C++");

        // forEach to iterate and display each key and value pair of HashMap
        hmap.forEach((key, value) -> System.out.println(key + " - " + value));


//
    }
}
