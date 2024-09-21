package com.gezi_rehberim.place_service.core.exception.placecategory;

import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

public class PlaceCategoryNotFoundException extends BaseBusinessException {
    public PlaceCategoryNotFoundException(String message) {
        super(message);
    }
}
