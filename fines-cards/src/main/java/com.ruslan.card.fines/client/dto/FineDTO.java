package com.ruslan.card.fines.client.dto;

import com.ruslan.card.fines.entity.FineCard;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class FineDTO {
    private String id;
    private BigDecimal amount;
    private FineCard.FineType fineType;
    private Date dueDate;
}
