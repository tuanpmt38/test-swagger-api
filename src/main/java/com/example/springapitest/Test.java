package com.example.springapitest;

import com.example.springapitest.utils.ConnectApi;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

public class Test {

    public static void main(String[] args) {

        ResponseEntity<String> response = ConnectApi.httpRequest("https://apix.shippo.vn/config/location/9");
        String result = response.getBody();
        System.out.println("------> " + result);

        JSONObject json = new JSONObject(result);
        Integer parentId = json.getJSONObject("result").getInt("parent_id");
        String namePath = json.getJSONObject("result").getString("name");
        String state = json.getJSONObject("result").getString("state");

    }
}
