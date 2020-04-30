package com.ruslan.card.regular.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.ruslan.card.regular.database")
public class RepoConfiguration {
}
