package com.ruslan.card.advice.service;

import com.ruslan.card.advice.configuration.AdviceProperties;
import com.ruslan.card.advice.entity.AdviceCard;
import com.ruslan.entity.CardType;
import com.ruslan.entity.UserData;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class AIAdviceService implements AdviceService {
    private final static Random rnd = new Random();
    private final AdviceProperties adviseProperties;

    @Override
    public List<AdviceCard> defineAdvices(UserData userData) {
        return IntStream.range(0, 10)
                .mapToObj(ind -> AdviceCard.builder()
                        .userId(userData.getUserId())
                        .amount(BigDecimal.valueOf(rnd.nextLong()))
                        .adviceType(AdviceCard.AdviceType.fromInt(rnd.nextInt(AdviceCard.AdviceType.values().length - 1)))
                        .id(UUID.randomUUID().toString())
                        .executionUrl(adviseProperties.getExecuteUrl())
                        .type(CardType.ADVISE)
                        .build())
                .collect(Collectors.toList());
    }
}
