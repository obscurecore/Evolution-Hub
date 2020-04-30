package com.ruslan.card.fines.service;

import com.ruslan.card.fines.entity.FineCard;
import com.ruslan.entity.UserData;

import java.util.List;

public interface FinesService {
    List<FineCard> loadFines(UserData userData);
}
