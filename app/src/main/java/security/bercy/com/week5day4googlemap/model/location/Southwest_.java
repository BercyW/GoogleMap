package security.bercy.com.week5day4googlemap.model.location;

/**
 * Created by Admin on 12/4/2017.
 */



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Southwest_ {

    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

}
