package eu.sk.jakab.kiwi.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/**
 * Created by jakab on 7/29/2019.
 */
public class Country {
    @SerializedName("code")
    @Expose
    @Getter
    private String code;

    @SerializedName("name")
    @Expose
    @Getter
    private String name;
}
