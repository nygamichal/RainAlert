package pl.nygamichal.rainalert.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 08.08.2017.
 */

public class Main {
  @SerializedName("temp")
  @Expose
  public Double temp;
  @SerializedName("pressure")
  @Expose
  public Double pressure;
  @SerializedName("humidity")
  @Expose
  public Long humidity;
  @SerializedName("temp_min")
  @Expose
  public Double tempMin;
  @SerializedName("temp_max")
  @Expose
  public Double tempMax;

}
