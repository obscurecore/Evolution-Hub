package com.ruslan.card.fines.service;

import com.ruslan.card.fines.client.AIClient;
import com.ruslan.card.fines.configuration.FinesProperties;
import com.ruslan.card.fines.entity.FineCard;
import com.ruslan.entity.CardType;
import com.ruslan.entity.UserData;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RemoteFinesService implements FinesService {
    private final static Random rnd = new Random();
    private final FinesProperties properties;
    private final AIClient AIClient;

    @Override
    public List<FineCard> loadFines(UserData userData) {
        return AIClient.getFines(userData.getUserId()).stream()
                .map(fine ->
                        FineCard.builder()
                                .userId(userData.getUserId())
                                .dueDate(fine.getDueDate().getTime())
                                .amount(fine.getAmount())
                                .fineType(fine.getFineType())
                                .id(fine.getId())
                                .executionUrl(properties.getExecuteUrl())
                                .type(CardType.FINES)
                                .build()
                ).collect(Collectors.toList());
    }
}
