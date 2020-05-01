package com.ruslan.hub.service;

import com.ruslan.entity.Card;
import com.ruslan.entity.UserData;
import reactor.core.publisher.Flux;

import java.util.List;

public interface CardsService {
    Flux<Card> loadCards(UserData userData);
}