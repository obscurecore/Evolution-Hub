package com.ruslan.hub.controller;

import com.ruslan.entity.Card;
import com.ruslan.entity.GeoPosition;
import com.ruslan.entity.UserData;
import com.ruslan.hub.service.CardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Callable;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("hub")
@RequiredArgsConstructor
public class HubController {
    private final CardsService cardsService;

    @RequestMapping(method = GET, value = "/cards", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Card> loadCards(@RequestHeader("userId") String userId,
                                @RequestHeader("longitude") BigDecimal longitude,
                                @RequestHeader("latitude") BigDecimal latitude,
                                @RequestParam("currentDate") Long currentDate) {
        return cardsService.loadCards(UserData.builder()
                .currentDate(currentDate)
                .userId(userId)
                .geoPosition(GeoPosition.builder()
                        .latitude(latitude)
                        .longitude(longitude)
                        .build())
                .build());
    }
}