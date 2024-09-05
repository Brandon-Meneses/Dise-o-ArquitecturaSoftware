package com.example.maxnumber;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MaxNumberClient {

    private final RestTemplate restTemplate;

    public MaxNumberClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public int getMaxNumber(int num1, int num2, int num3, int num4) {
        String url = String.format("http://localhost:8080/max-number?num1=%d&num2=%d&num3=%d&num4=%d", num1, num2, num3, num4);
        return restTemplate.getForObject(url, Integer.class);
    }
}