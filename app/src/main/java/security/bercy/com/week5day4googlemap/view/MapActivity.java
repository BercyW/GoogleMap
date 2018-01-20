package security.bercy.com.week5day4googlemap.view;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import security.bercy.com.week5day4googlemap.R;

public class MapActivity extends AppCompatActivity {
    String[] permissionToBeAsked;
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 10;
    private FusedLocationProviderClient providerClient;
    private Location currentLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        permissionToBeAsked = new String[]{
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION

        };
        checkLocationPermission();
    }

    private void checkLocationPermission() {


        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                permissionToBeAsked[0]) != PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(this,
                        permissionToBeAsked[1]) != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    permissionToBeAsked[0]) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this,
                            permissionToBeAsked[1])) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                showExplanation();
            } else {

                // No explanation needed, we can request the permission.

                askPermission();

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }else {
            getLocation();
        }



    }
    @SuppressLint("MissingPermission")
    public void getLocation() {
        providerClient = LocationServices.getFusedLocationProviderClient(this);
        providerClient.getLastLocation()
                .addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
//                        Log.d(TAG, "onSuccess: " + location.toString());
                        currentLocation = location;
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    private void showExplanation() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle("Location Required")
                .setMessage("You need to allow the location permission").setNegativeButton("Uninstall", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        uninstallApplication();
                    }
                }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        askPermission();
                    }
                }).create();
        alertDialog.show();
    }

    private void uninstallApplication() {

        Intent intent = new Intent(Intent.ACTION_DELETE);
        intent.setData(Uri.parse("package:security.bercy.com.locationandgooglemaps"));
        startActivity(intent);
    }
    private void askPermission() {

        ActivityCompat.requestPermissions(this,
                permissionToBeAsked,
                MY_PERMISSIONS_REQUEST_READ_CONTACTS);
    }

    public void getLocationFromAddress(View view) {

    }

    public void getAddressFromLocation(View view) {

    }

    public void addLocation(View view) {

    }

    public void displayLocations(View view) {

    }
}
