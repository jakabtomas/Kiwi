package eu.sk.jakab.kiwi.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

import java.util.List;
import java.util.Map;

import lombok.Getter;

/**
 * Created by jakab on 7/29/2019.
 */
public class Flight {
    public static final String TIER1 = "1";
    public static final String TIER2 = "2";
    public static final String HAND = "hand";

    @SerializedName("id")
    @Expose
    @Getter
    private String id;

    @SerializedName("countryFrom")
    @Expose
    @Getter
    private Country countryFrom;

    @SerializedName("countryTo")
    @Expose
    @Getter
    private Country countryTo;

    @SerializedName("bags_price")
    @Expose
    @Getter
    private Map<String, Double> bagsPrice;

    @SerializedName("baglimit")
    @Expose
    @Getter
    private BagLimit baglimit;

    @SerializedName("dTime")
    @Expose
    @Getter
    private DateTime departureTime;

    @SerializedName("aTime")
    @Expose
    @Getter
    private DateTime arrivalTime;

    @SerializedName("dTimeUTC")
    @Expose
    @Getter
    private DateTime departureTimeUTC;

    @SerializedName("aTimeUTC")
    @Expose
    @Getter
    private DateTime arrivalTimeUTC;

    @SerializedName("price")
    @Expose
    @Getter
    private int price;

    @SerializedName("flyFrom")
    @Expose
    @Getter
    private String flyFrom;

    @SerializedName("flyTo")
    @Expose
    @Getter
    private String flyTo;

    @SerializedName("distance")
    @Expose
    @Getter
    private double distance;

    @SerializedName("cityFrom")
    @Expose
    @Getter
    private String cityFrom;

    @SerializedName("cityTo")
    @Expose
    @Getter
    private String cityTo;

    @SerializedName("route")
    @Expose
    @Getter
    private List<Route> route = null;

    @SerializedName("has_airport_change")
    @Expose
    @Getter
    private boolean hasAirportChange;

    @SerializedName("fly_duration")
    @Expose
    @Getter
    private String flyDuration;

    @SerializedName("mapIdto")
    @Expose
    @Getter
    private String mapIdto;
}
