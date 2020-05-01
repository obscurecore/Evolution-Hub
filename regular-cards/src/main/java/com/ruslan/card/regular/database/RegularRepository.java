package com.ruslan.card.regular.database;

import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.Date;
import java.util.List;

public interface RegularRepository extends ReactiveMongoRepository<RegularDocument, String> {
    Flux<RegularDocument> findByUserIdAndDueDateBetween(String userId, Date from, Date to);
}
