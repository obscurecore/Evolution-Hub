package com.ruslan.card.advice.service;

import com.ruslan.card.advice.entity.AdviceCard;
import com.ruslan.entity.UserData;

import java.util.List;

public interface AdviceService {
    List<AdviceCard> defineAdvices(UserData userData);
}
