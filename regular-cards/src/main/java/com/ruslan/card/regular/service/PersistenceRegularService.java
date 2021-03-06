package com.ruslan.card.regular.service;

import com.ruslan.card.regular.configuration.RegularProperties;
import com.ruslan.card.regular.database.RegularRepository;
import com.ruslan.card.regular.entity.RegularCard;
import com.ruslan.entity.CardType;
import com.ruslan.entity.UserData;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PersistenceRegularService implements RegularService {
    private final RegularProperties properties;
    private final RegularRepository regularRepository;
    private static final long DAY = 86_400_000;

    @Override
    public Flux<RegularCard> loadRegular(UserData userData) {
        Date from = new Date(userData.getCurrentDate() - DAY);
        Date to = new Date(userData.getCurrentDate() + DAY);
        return regularRepository.findByUserIdAndDueDateBetween(userData.getUserId(), from, to)
                .map(doc ->
                        RegularCard.builder()
                                .userId(userData.getUserId())
                                .dueDate(doc.getDueDate().getTime())
                                .amount(doc.getAmount())
                                .targetAccount(doc.getTargetAccount())
                                .id(doc.getId())
                                .executionUrl(properties.getExecuteUrl())
                                .type(CardType.REGULAR)
                                .build()
                );
    }
}
