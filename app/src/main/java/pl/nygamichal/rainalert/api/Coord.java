package pl.nygamichal.rainalert.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 08.08.2017.
 */

public class Coord {
  @SerializedName("lon")
  @Expose
  public Double lon;
  @SerializedName("lat")
  @Expose
  public Double lat;
}
