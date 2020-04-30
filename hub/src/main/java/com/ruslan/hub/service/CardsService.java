package com.ruslan.hub.service;

import com.ruslan.entity.Card;
import com.ruslan.entity.UserData;

import java.util.List;

public interface CardsService {
    List<Card> loadCards(UserData userData);
}
