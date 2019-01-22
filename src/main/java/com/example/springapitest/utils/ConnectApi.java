package com.example.springapitest.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class ConnectApi {

    private static final Logger logger = LogManager.getLogger(ConnectApi.class);

    public static ResponseEntity httpRequest (String url){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> respon = null;
        try {
             respon = restTemplate.exchange(
                    url, HttpMethod.GET, entity, String.class);
        }catch (Exception e){
            logger.info("error connect api", e);
        }

        return respon;
    }
}
