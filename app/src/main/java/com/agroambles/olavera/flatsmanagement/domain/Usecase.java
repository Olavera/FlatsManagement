package com.agroambles.olavera.flatsmanagement.domain;

import rx.Observable;

/**
 * @author Olavera
 */
public interface Usecase<T> {

    Observable<T> execute();
}
