package com.agroambles.olavera.flatsmanagement.model.rest;

import com.agroambles.olavera.flatsmanagement.model.entities.Building;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * @author Olavera
 */
public interface RestApi {

    public static final String END_POINT                    = "http://";
    public static final String RESOURCE_GETBUILDINGLIST     = "";

    @GET(RESOURCE_GETBUILDINGLIST)
    Observable< List <Building>> getBuildingList();
}
