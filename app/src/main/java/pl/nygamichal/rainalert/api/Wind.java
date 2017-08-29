package pl.nygamichal.rainalert.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 08.08.2017.
 */

public class Wind {
  @SerializedName("speed") @Expose public Double speed;
  @SerializedName("deg") @Expose public Double deg;
}
