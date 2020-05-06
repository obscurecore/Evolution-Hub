package com.ruslan.card.fines.controller;

import com.ruslan.card.fines.entity.FineCard;
import com.ruslan.card.fines.service.FinesService;
import com.ruslan.entity.UserData;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FinesController {
    private final FinesService finesService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<FineCard> loadFines(@RequestHeader("userId") String userId) {
        return finesService.loadFines(UserData.builder()
                .userId(userId)
                .build());
    }
}
