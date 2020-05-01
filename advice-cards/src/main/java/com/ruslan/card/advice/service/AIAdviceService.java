package com.ruslan.card.advice.service;

import com.ruslan.card.advice.configuration.AdviceProperties;
import com.ruslan.card.advice.entity.AdviceCard;
import com.ruslan.entity.CardType;
import com.ruslan.entity.UserData;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AIAdviceService implements AdviceService {
    private final static Random rnd = new Random();
    private final AdviceProperties adviseProperties;

    @Override
    public Flux<AdviceCard> defineAdvices(UserData userData) {
        final Stream<AdviceCard> adviceCardStream = IntStream.range(0, 10)
                .mapToObj(ind -> AdviceCard.builder()
                        .userId(userData.getUserId())
                        .amount(BigDecimal.valueOf(rnd.nextLong()))
                        .adviceType(AdviceCard.AdviceType.fromInt(rnd.nextInt(AdviceCard.AdviceType.values().length - 1)))
                        .id(UUID.randomUUID().toString())
                        .executionUrl(adviseProperties.getExecuteUrl())
                        .type(CardType.ADVISE)
                        .build());
        return Flux.fromStream(adviceCardStream);
    }
}
