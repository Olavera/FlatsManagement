package com.agroambles.olavera.flatsmanagement.domain;

import rx.Subscriber;
import rx.Subscription;

/**
 * @author Olavera
 */
public interface Usecase {

    Subscription execute(Subscriber subscriber);
}
