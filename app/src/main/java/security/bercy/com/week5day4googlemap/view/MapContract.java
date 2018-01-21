package security.bercy.com.week5day4googlemap.view;

import android.location.Address;

import security.bercy.com.week5day4googlemap.utils.BasePresenter;
import security.bercy.com.week5day4googlemap.utils.BaseView;

/**
 * Created by Bercy on 1/19/18.
 */

public interface MapContract {

   interface View extends BaseView {
       void updateLatLng(String address);
       void updateAddress(Address address);
   }
   interface Presenter extends BasePresenter<View> {
       void checkPermission();
       void getLocationFromAddress(String address);
       void displayLocations();
       void setCurrentLocation();
   }

}
