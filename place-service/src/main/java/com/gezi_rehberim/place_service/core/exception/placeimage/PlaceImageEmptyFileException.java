package com.gezi_rehberim.place_service.core.exception.placeimage;

import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

public class PlaceImageEmptyFileException extends BaseBusinessException {
    public PlaceImageEmptyFileException(String message) {
        super(message);
    }
}
