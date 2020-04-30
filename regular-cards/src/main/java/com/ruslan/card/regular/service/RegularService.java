package com.ruslan.card.regular.service;


import com.ruslan.card.regular.entity.RegularCard;
import com.ruslan.entity.UserData;

import java.util.List;


public interface RegularService {
    List<RegularCard> loadRegular(UserData userData);
}
