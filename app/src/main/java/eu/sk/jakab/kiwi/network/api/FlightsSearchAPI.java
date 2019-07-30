package eu.sk.jakab.kiwi.network.api;

import eu.sk.jakab.kiwi.network.model.FlightSearchResult;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jakab on 7/29/2019.
 */
public interface FlightsSearchAPI {
    @GET("flights")
    Observable<FlightSearchResult> getDailyFlights(
            @Query("v") int v,
            @Query("sort") String sort,
            @Query("locale") String locale,
            @Query("flyFrom") String flyFrom,
            @Query("to")String flyTo,
            @Query("featureName")String featureName,
            @Query("dateFrom") String dateFrom,
            @Query("dateTo") String dateTo,
            @Query("typeFlight") String typeflight,
            @Query("adults") int adults,
            @Query("limit") int limit,
            @Query("oneforcity") int oneforcity
    );
}
