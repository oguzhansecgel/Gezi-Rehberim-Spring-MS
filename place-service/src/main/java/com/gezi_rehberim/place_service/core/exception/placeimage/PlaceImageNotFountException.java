package com.gezi_rehberim.place_service.core.exception.placeimage;

import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

public class PlaceImageNotFountException extends BaseBusinessException {
    public PlaceImageNotFountException(String message) {
        super(message);
    }
}
