package pl.nygamichal.rainalert.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 08.08.2017.
 */

public class Weather {
  @SerializedName("id")
  @Expose
  public Long id;
  @SerializedName("main")
  @Expose
  public String main;
  @SerializedName("description")
  @Expose
  public String description;
  @SerializedName("icon")
  @Expose
  public String icon;
}
