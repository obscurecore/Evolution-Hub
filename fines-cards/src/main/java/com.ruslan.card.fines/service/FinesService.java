package com.ruslan.card.fines.service;

import com.ruslan.card.fines.entity.FineCard;
import com.ruslan.entity.UserData;
import reactor.core.publisher.Flux;

public interface FinesService {
    Flux<FineCard> loadFines(UserData userData);
}
