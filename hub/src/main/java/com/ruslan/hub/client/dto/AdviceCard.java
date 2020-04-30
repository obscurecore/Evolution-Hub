package com.ruslan.hub.client.dto;

import com.ruslan.entity.Card;
import com.ruslan.entity.CardType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class AdviceCard extends Card {
    private AdviceType adviceType;
    @Builder
    public AdviceCard(String id, String userId, CardType type, BigDecimal amount, String executionUrl, AdviceType adviceType) {
       super(id,userId,type,amount,executionUrl);
        this.adviceType = adviceType;
    }

    public enum AdviceType {
        GIFT,
        TAXI,
        CURRENCY;

        public static AdviceType fromInt(int i) {
            return AdviceType.values()[i];
        }
    }
}
