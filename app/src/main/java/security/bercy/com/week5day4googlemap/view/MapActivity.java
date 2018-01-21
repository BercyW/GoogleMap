package security.bercy.com.week5day4googlemap.view;

import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;

import javax.inject.Inject;

import security.bercy.com.week5day4googlemap.R;
import security.bercy.com.week5day4googlemap.di.component.DaggerMapComponent;


public class MapActivity extends AppCompatActivity implements MapContract.View{
    private static final String TAG = "MapActivity";
    String[] permissionToBeAsked;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 10;
    private FusedLocationProviderClient providerClient;
    private Location currentLocation;
    private Button bottomCurrentAddress;
    @Inject
    MapPresenter presenter;
    private TextView tv_bottomCurrentAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMapComponent.builder().build().inject(this);



        presenter.attachView(this);
        presenter.checkPermission();

        bingView();


        clickEnvent();

    }

    private void clickEnvent() {
        bottomCurrentAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.setCurrentLocation();
            }
        });
    }

    private void bingView() {
        bottomCurrentAddress = findViewById(R.id.btn_bottom_currentLocation);
        tv_bottomCurrentAddress = findViewById(R.id.tv_bottom_showCoordinates);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                } else {
                    Log.d(TAG, "onRequestPermissionsResult: ");
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
    }








    @Override
    public void showError(String error) {

    }

    @Override
    public void updateLatLng(String address) {

    }

    @Override
    public void updateAddress(Address address) {
        tv_bottomCurrentAddress.setText(address.getCountryName()+"-"+address.getLocality());
    }
}
