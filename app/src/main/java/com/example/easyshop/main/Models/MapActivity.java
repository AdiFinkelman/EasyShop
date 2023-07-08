package com.example.easyshop.main.Models;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.easyshop.R;
import com.example.easyshop.main.Logic.DataManager;
import com.example.easyshop.main.Utilities.MySP;
import com.example.easyshop.main.Utilities.NearbyPlaces;
import com.example.easyshop.main.Utilities.SignalGenerator;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.example.easyshop.databinding.ActivityMapBinding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.maps.model.PlacesSearchResult;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap gMap;
    private ActivityMapBinding binding;
    private Context context;
    private final int FINE_PERMISSION_CODE = 1;
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    public boolean locationPermissionGranted = false;
    private double latitude;
    private double longitude;
    private int PROXIMITY_RADIUS = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        context = this;
        initMap();
        getLocationPermission();
        onClickMyLocation(getCurrLatLng());
        showNearbyPlaces();
    }

    private void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        gMap = googleMap;
        LatLng latLng = new LatLng(latitude, longitude);
        moveCamera(latLng, 17.0f);
    }

    public void getLocationPermission() {
        String[] permission = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};

        if (ContextCompat.checkSelfPermission(context, FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(context, COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                locationPermissionGranted = true;
                initMap();
            }
        } else {
            if (this != null)
                ActivityCompat.requestPermissions(this, permission, FINE_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        locationPermissionGranted = false;
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == FINE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                locationPermissionGranted = false;
            } else {
                locationPermissionGranted = true;
                SignalGenerator.getInstance().toast("Location Permission is denied", Toast.LENGTH_SHORT);
            }
        }
    }

    private LatLng getCurrLatLng() {
        LatLng latLng;
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
            SignalGenerator.getInstance().toast("You should permit location access", Toast.LENGTH_SHORT);
            return null;
        }

        Location currLocation = null;
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            currLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }
        if (currLocation == null && locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            currLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }
        if (currLocation == null && locationManager.isProviderEnabled(LocationManager.PASSIVE_PROVIDER)) {
            currLocation = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
        }

        if (currLocation != null) {
            latitude = currLocation.getLatitude();
            longitude = currLocation.getLongitude();
        }
        latLng = new LatLng(latitude,longitude);
        return latLng;
    }

    public void moveCamera(LatLng latLng, float zoom) {
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 20.0f));
        gMap.animateCamera(CameraUpdateFactory.zoomTo(zoom));
    }

    private void onClickMyLocation(LatLng latLng) {
        AppCompatImageButton myLocation_BTN_map = findViewById(DataManager.getMyLocation_BTN_map());
        myLocation_BTN_map.setOnClickListener(v -> {
            moveCamera(latLng, 17.0f);
        });
    }

    private void openMenuActivity() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

    private void showNearbyPlaces() {
        StringBuilder sb = new StringBuilder(
                "http://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        sb.append("location=" + latitude + ", " + longitude);
        sb.append("&radius=1000");
        sb.append("&type=supermarket");
        sb.append("&sensor=true");
        sb.append("&key=" + getResources().getString(R.string.google_api_key));

        String url = sb.toString();
        Object dataTransfer[] = new Object[2];
        dataTransfer[0] = gMap;
        dataTransfer[1] = url;

        NearbyPlaces nearbyPlaces = new NearbyPlaces();
        nearbyPlaces.execute(dataTransfer);
        SignalGenerator.getInstance().toast("Showing nearby supermarkets", Toast.LENGTH_SHORT);
    }

    @Override
    public void onBackPressed() {
        openMenuActivity();
    }
}