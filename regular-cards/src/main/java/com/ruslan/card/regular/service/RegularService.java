package com.ruslan.card.regular.service;


import com.ruslan.card.regular.entity.RegularCard;
import com.ruslan.entity.UserData;
import reactor.core.publisher.Flux;


public interface RegularService {
    Flux<RegularCard> loadRegular(UserData userData);
}
