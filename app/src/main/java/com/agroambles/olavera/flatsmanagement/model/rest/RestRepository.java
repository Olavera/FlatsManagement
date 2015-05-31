package com.agroambles.olavera.flatsmanagement.model.rest;

import com.agroambles.olavera.flatsmanagement.model.Repository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Inject;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * @author Olavera
 */
public class RestRepository implements Repository {

    private final RestApi mRestApi;

    @Inject
    public RestRepository() {

//        Gson gson = new GsonBuilder()
//                .registerTypeAdapterFactory(new CharacterItemAdapterFactory())
//                .create();

        RestAdapter marvelApiAdapter = new RestAdapter.Builder()
                .setEndpoint(RestApi.END_POINT)
                .setLogLevel(RestAdapter.LogLevel.HEADERS_AND_ARGS)
                //.setConverter(new GsonConverter(gson))
                .build();

        mRestApi = marvelApiAdapter.create(RestApi.class);

    }
}
