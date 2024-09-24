package com.gezi_rehberim.favorite_place_service.core.exception.place;

import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

public class PlaceNotFoundException extends BaseBusinessException {
    public PlaceNotFoundException(String message) {
        super(message);
    }
}
