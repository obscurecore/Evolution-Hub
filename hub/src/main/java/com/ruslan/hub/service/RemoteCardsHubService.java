package com.ruslan.hub.service;

import com.ruslan.entity.Card;
import com.ruslan.entity.UserData;
import com.ruslan.hub.client.CardClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RemoteCardsHubService implements CardsService {
    private final List<CardClient> cardClients;

    @Override
    public Flux<List<Card>> loadCards(UserData userData) {
        final List<Mono<List<Card>>> monoList = cardClients.stream()
                .map(client -> getCards(userData, client))
                .collect(Collectors.toList());
        return Flux.merge(monoList);
    }
//calling http request wrap into mono to create stream and set up subscribeOn to extend thread pool
    @SuppressWarnings("unchecked")
    private Mono<List<Card>> getCards(UserData userData, CardClient client) {
        return Mono.<List<Card>>fromCallable(() -> client.getCards(userData.getUserId(),
                userData.getGeoPosition().getLongitude(), userData.getGeoPosition().getLatitude(),
                userData.getCurrentDate()))
                .subscribeOn(Schedulers.elastic());
    }
}