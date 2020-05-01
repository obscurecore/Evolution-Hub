package com.ruslan.card.fines.client;

import com.ruslan.card.fines.client.dto.FineDTO;
import com.ruslan.card.fines.client.dto.FinesResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class AIClient {

    private final WebClient client ;

    public AIClient(@Value("${fines.AIServerURL}") String baseURL) {
        client = WebClient.create(baseURL);
    }

    public Mono<List<FineDTO>> getFines(String userId) {
       return client.get()
               .uri(uriBuilder -> uriBuilder.path("/fines").queryParam("userId", userId).build())
               .exchange()
               .flatMap(res->res.bodyToMono(FinesResponse.class));
    }
}
