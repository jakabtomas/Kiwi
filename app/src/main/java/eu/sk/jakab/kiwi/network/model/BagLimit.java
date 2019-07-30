package eu.sk.jakab.kiwi.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/**
 * Created by jakab on 7/29/2019.
 */
public  class BagLimit {
    @SerializedName("hold_width")
    @Expose
    @Getter
    private  int holdWidth;

    @SerializedName("hold_height")
    @Expose
    @Getter
    private  int holdHeight;

    @SerializedName("hold_length")
    @Expose
    @Getter
    private  int holdLength;

    @SerializedName("hold_weight")
    @Expose
    @Getter
    private  int holdWeight;

    @SerializedName("hand_width")
    @Expose
    @Getter
    private  int handWidth;

    @SerializedName("hand_height")
    @Expose
    @Getter
    private  int handHeight;

    @SerializedName("hand_length")
    @Expose
    @Getter
    private  int handLength;

    @SerializedName("hand_weight")
    @Expose
    @Getter
    private  int handWeight;

}
