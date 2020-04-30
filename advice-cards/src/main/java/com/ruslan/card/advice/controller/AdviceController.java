package com.ruslan.card.advice.controller;

import com.ruslan.entity.GeoPosition;
import com.ruslan.entity.UserData;
import lombok.RequiredArgsConstructor;
import com.ruslan.card.advice.entity.AdviceCard;
import com.ruslan.card.advice.service.AdviceService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdviceController {
    private final AdviceService adviceService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AdviceCard> loadAdvices(@RequestHeader("userId") String userId,
                                        @RequestHeader("longitude") BigDecimal longitude,
                                        @RequestHeader("latitude") BigDecimal latitude,
                                        @RequestParam("currentDate") Long currentDate) {
        return adviceService.defineAdvices(UserData.builder()
                .currentDate(currentDate)
                .userId(userId)
                .geoPosition(GeoPosition.builder()
                        .latitude(latitude)
                        .longitude(longitude)
                        .build())
                .build());
    }
}
