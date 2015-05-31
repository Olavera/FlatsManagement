package com.agroambles.olavera.flatsmanagement.injector.annotations;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Olavera
 */
@Scope
@Retention(RUNTIME)
public @interface Activity {}
