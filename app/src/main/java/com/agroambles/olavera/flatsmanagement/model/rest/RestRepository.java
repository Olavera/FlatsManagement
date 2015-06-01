package com.agroambles.olavera.flatsmanagement.model.rest;

import com.agroambles.olavera.flatsmanagement.model.Repository;
import com.agroambles.olavera.flatsmanagement.model.entities.Building;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import javax.inject.Inject;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import rx.Observable;

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

                //.setConverter(new GsonConverter(gson))

        mRestApi = RestServiceGenerator.createService(RestApi.class, RestApi.END_POINT,
                5, 20, "", "");
    }

    @Override
    public Observable<List<Building>> getBuildingList() {
        return mRestApi.getBuildingList();
    }
}
