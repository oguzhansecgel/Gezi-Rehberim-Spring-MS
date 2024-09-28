package com.gezi_rehberim.favorite_place_service.core.exception.favoriteplace;

import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

public class FavoritePlaceNotFoundException extends BaseBusinessException {
    public FavoritePlaceNotFoundException(String message) {
        super(message);
    }
}
