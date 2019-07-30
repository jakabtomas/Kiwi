package eu.sk.jakab.kiwi.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/**
 * Created by jakab on 7/29/2019.
 */
public  class Route {
    @SerializedName("id")
    @Expose
    @Getter
    private  String id;
    @SerializedName("combination_id")
    @Expose
    @Getter
    private  String combinationId;
    @SerializedName("return")
    @Expose
    @Getter
    private  int _return;
    @SerializedName("original_return")
    @Expose
    @Getter
    private  int originalReturn;
    @SerializedName("source")
    @Expose
    @Getter
    private  String source;
    @SerializedName("found_on")
    @Expose
    @Getter
    private  String foundOn;
    @SerializedName("price")
    @Expose
    @Getter
    private  int price;
    @SerializedName("aTime")
    @Expose
    @Getter
    private  int aTime;
    @SerializedName("dTime")
    @Expose
    @Getter
    private  int dTime;
    @SerializedName("aTimeUTC")
    @Expose
    @Getter
    private  int aTimeUTC;
    @SerializedName("dTimeUTC")
    @Expose
    @Getter
    private  int dTimeUTC;
    @SerializedName("mapIdfrom")
    @Expose
    @Getter
    private  String mapIdfrom;
    @SerializedName("mapIdto")
    @Expose
    @Getter
    private  String mapIdto;
    @SerializedName("cityTo")
    @Expose
    @Getter
    private  String cityTo;
    @SerializedName("cityFrom")
    @Expose
    @Getter
    private  String cityFrom;
    @SerializedName("flyTo")
    @Expose
    @Getter
    private  String flyTo;
    @SerializedName("airline")
    @Expose
    @Getter
    private  String airline;
    @SerializedName("operating_carrier")
    @Expose
    @Getter
    private  String operatingCarrier;
    @SerializedName("equipment")
    @Expose
    @Getter
    private  String equipment;
    @SerializedName("flyFrom")
    @Expose
    @Getter
    private  String flyFrom;
    @SerializedName("latFrom")
    @Expose
    @Getter
    private  double latFrom;
    @SerializedName("lngFrom")
    @Expose
    @Getter
    private  double lngFrom;
    @SerializedName("latTo")
    @Expose
    @Getter
    private  double latTo;
    @SerializedName("lngTo")
    @Expose
    @Getter
    private  double lngTo;
    @SerializedName("flight_no")
    @Expose
    @Getter
    private  int flightNo;
    @SerializedName("vehicle_type")
    @Expose
    @Getter
    private  String vehicleType;
    @SerializedName("refresh_timestamp")
    @Expose
    @Getter
    private  int refreshTimestamp;
    @SerializedName("bags_recheck_required")
    @Expose
    @Getter
    private  boolean bagsRecheckRequired;
    @SerializedName("guarantee")
    @Expose
    @Getter
    private  boolean guarantee;
    @SerializedName("fare_classes")
    @Expose
    @Getter
    private  String fareClasses;
    @SerializedName("fare_basis")
    @Expose
    @Getter
    private  String fareBasis;
    @SerializedName("fare_family")
    @Expose
    @Getter
    private  String fareFamily;
    @SerializedName("fare_category")
    @Expose
    @Getter
    private  String fareCategory;
    @SerializedName("last_seen")
    @Expose
    @Getter
    private  int lastSeen;
    @SerializedName("operating_flight_no")
    @Expose
    @Getter
    private  String operatingFlightNo;
}
