package eu.sk.jakab.kiwi.network.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/**
 * Created by jakab on 7/29/2019.
 */
public class FlightSearchResult {

    @SerializedName("search_id")
    @Expose
    private String searchId;

    @SerializedName("data")
    @Expose
    @Getter
    private List<Flight> data = null;

    @SerializedName("currency")
    @Expose
    @Getter
    private String currency;
}
