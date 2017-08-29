package pl.nygamichal.rainalert.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 08.08.2017.
 */

public class WeatherResponse {
    @SerializedName("coord") @Expose public Coord coord;
    @SerializedName("weather") @Expose
    public List<Weather> weather = new ArrayList<Weather>();
    @SerializedName("base") @Expose public String base;
    @SerializedName("main") @Expose public Main main;
    @SerializedName("visibility") @Expose public Long visibility;
    @SerializedName("wind") @Expose public Wind wind;
    @SerializedName("clouds") @Expose public Clouds clouds;
    @SerializedName("dt") @Expose public Long dt;
    @SerializedName("sys") @Expose public Sys sys;
    @SerializedName("id") @Expose public Long id;
    @SerializedName("name") @Expose public String name;
    @SerializedName("cod") @Expose public Long cod;
}
