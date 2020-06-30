package hcmute.edu.vn.foody07;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

public class CurrentLocationActivity extends AppCompatActivity {
    private static final int REQUESST_CODE = 1;
    public double latitude = 0;
    public double longitude = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(CurrentLocationActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUESST_CODE);
        } else {
            getCurrentLocation();

            /*Toast.makeText(CurrentLocationActivity.this, "Succesfull in "+latitude+" | "+longitude, Toast.LENGTH_SHORT).show();
            Toast.makeText(CurrentLocationActivity.this, "Succesfull in "+latitude+" | "+longitude, Toast.LENGTH_SHORT).show();
            Toast.makeText(CurrentLocationActivity.this, "Succesfull in "+latitude+" | "+longitude, Toast.LENGTH_SHORT).show();*/

            /*Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("latitude",latitude);
            intent.putExtra("longitude",longitude);
            startActivity(intent);*/

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUESST_CODE && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation();
            } else {
                Toast.makeText(CurrentLocationActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getCurrentLocation() {
        final LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(3000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.getFusedLocationProviderClient(CurrentLocationActivity.this)
                .requestLocationUpdates(locationRequest, new LocationCallback() {
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        super.onLocationResult(locationResult);
                        LocationServices.getFusedLocationProviderClient(CurrentLocationActivity.this)
                                .removeLocationUpdates(this);
                        if (locationResult != null && locationResult.getLocations().size() > 0) {
                            int lastestLocationIndex = locationResult.getLocations().size() - 1;
                            latitude = locationResult.getLocations().get(lastestLocationIndex).getLatitude();
                            longitude = locationResult.getLocations().get(lastestLocationIndex).getLongitude();
                            MoveToMain();
                        }
                    }
                }, Looper.getMainLooper());
    }


    private void MoveToMain()
     {
         Intent intent = new Intent(this, MainActivity.class);
         intent.putExtra("latitude",latitude);
         intent.putExtra("longitude",longitude);
         startActivity(intent);
     }

   // public  double getLatitude(){ return latitude;}
   // public  double getLongitude(){return  longitude;}


}
