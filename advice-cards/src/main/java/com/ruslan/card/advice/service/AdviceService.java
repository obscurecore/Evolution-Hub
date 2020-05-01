package com.ruslan.card.advice.service;

import com.ruslan.card.advice.entity.AdviceCard;
import com.ruslan.entity.UserData;
import reactor.core.publisher.Flux;

public interface AdviceService {
    Flux<AdviceCard> defineAdvices(UserData userData);
}
