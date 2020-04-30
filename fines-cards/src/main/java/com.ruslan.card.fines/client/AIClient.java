package com.ruslan.card.fines.client;

import com.ruslan.card.fines.client.dto.FineDTO;
import com.ruslan.card.fines.client.dto.FinesResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Service
public class AIClient {

    private final RestTemplate restTemplate;
    private final String baseURL;

    public AIClient(@Value("${fines.AIServerURL}") String baseURL) {
        restTemplate = new RestTemplate();
        this.baseURL = baseURL;
    }

    public List<FineDTO> getFines(String userId) {
        return restTemplate.getForObject(baseURL + "/fines?userId={userId}", FinesResponse.class, userId);
    }
}
