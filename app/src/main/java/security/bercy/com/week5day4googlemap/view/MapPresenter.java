package security.bercy.com.week5day4googlemap.view;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import static security.bercy.com.week5day4googlemap.view.MapActivity.MY_PERMISSIONS_REQUEST_LOCATION;

/**
 * Created by Bercy on 1/19/18.
 */

public class MapPresenter implements MapContract.Presenter {
    String[] permissionToBeAsked;
    MapContract.View view;
    @Inject
    public MapPresenter() {

    }


    @Override
    public void attachView(MapContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void checkPermission() {
        //Check for Location Permission
        if (ContextCompat.checkSelfPermission((Context)view,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity)view,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions((Activity)view,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
        } else {
            //You have permission. You can do stuff here!
        }


    }


    @Override
    public void getLocationFromAddress(String address) {

    }

    @Override
    public void displayLocations() {

    }

    @Override
    public void setCurrentLocation() {
        Geocoder geocoder = new Geocoder((Context) view);
        try {
            List<Address> addresses = geocoder.getFromLocation(55.4,44.2,1);

            view.updateAddress(addresses.get(0));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
