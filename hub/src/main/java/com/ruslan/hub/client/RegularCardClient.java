package com.ruslan.hub.client;

import com.ruslan.hub.client.dto.RegularCard;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RegularCardClient implements CardClient<RegularCard> {
    private final BaseCardClient cardClient;

    public RegularCardClient(@Value("${hub.regularURL}") String url) {
        this.cardClient = new BaseCardClient(url);
    }

    public List<RegularCard> getCards(String userId,
                                      BigDecimal longitude,
                                      BigDecimal latitude,
                                      Long currentDate) {
        return cardClient.<RegularCard>getCards(userId, longitude, latitude, currentDate, MediaType.APPLICATION_JSON)
                .getBody();
    }
}
