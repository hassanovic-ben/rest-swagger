package com.hassan.client;

import com.hassan.model.Shoe;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class ShoeClientsRest {

    private static final String path = "http://localhost:8080";
    private static HttpStatus statusCode;

    public static List<? extends Object> getShoes() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(path + "/shoes", Object[].class);
        Object[] objects = responseEntity.getBody();
        statusCode = responseEntity.getStatusCode();
        List<Object> allShoes = Arrays.asList(objects);
        return allShoes;

    }

    public static Shoe postShoe() {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Shoe> request = new HttpEntity<>(new Shoe("SHOE POST CLIENT", 45, "ADIDAS", 250, "BLUE"));
        Shoe shoePosted = restTemplate.postForObject(path + "/shoe", request, Shoe.class);
        return shoePosted;

    }


}
