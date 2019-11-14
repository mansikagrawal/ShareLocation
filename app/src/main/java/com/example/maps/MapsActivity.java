package com.example.maps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private  static final LatLng M_P=new LatLng(28.40696,78.1049);
    private  static final LatLng P_H=new LatLng(-25.786508,28.271187);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.hotel))
                 .anchor(0.0f,1.0f)
                .title("HOTEL")
                .position(P_H));

       // mMap.addMarker(new MarkerOptions()
             //   .icon(BitmapDescriptorFactory.fromResource(R.mipmap.mall))
              //  .anchor(0.0f,1.0f)
              //  .title("MALL")
              //  .position(M_P));



        // Add a marker in Sydney and move the camera
       // LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.map,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
     switch (item.getItemId())
     {
         case R.id.action_normal:
             mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);break;
         case R.id.action_hybrid:
             mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);break;
         case R.id.action_none:
             mMap.setMapType(GoogleMap.MAP_TYPE_NONE);break;
         case R.id.action_satellite:
             mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);break;
         case R.id.action_terrain:
             mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);break;
     }
    return true;
    }
}
