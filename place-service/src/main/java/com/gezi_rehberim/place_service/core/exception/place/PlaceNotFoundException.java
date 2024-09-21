package com.gezi_rehberim.place_service.core.exception.place;

import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

public class PlaceNotFoundException extends BaseBusinessException {
    public PlaceNotFoundException(String message) {
        super(message);
    }
}
