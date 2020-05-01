package com.ruslan.hub.client;


import com.ruslan.entity.Card;
import com.ruslan.hub.client.dto.FineCard;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;

public interface CardClient<T extends Card> {
    Flux<T> getCards(String userId,
                            BigDecimal longitude,
                            BigDecimal latitude,
                            Long currentDate);
}
