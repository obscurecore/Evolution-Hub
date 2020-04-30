package com.ruslan.hub.client;


import com.ruslan.entity.Card;

import java.math.BigDecimal;
import java.util.List;

public interface CardClient<T extends Card> {
    List<T> getCards(String userId,
                     BigDecimal longitude,
                     BigDecimal latitude,
                     Long currentDate);
}
