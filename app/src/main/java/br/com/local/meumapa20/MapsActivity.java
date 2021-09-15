package br.com.local.meumapa20;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    double latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;


        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);


        latitude = -23.5856101;
        longitude = -46.6669873;

        String local = "Parque do Ibirapuera";

        final LatLng posicao = new LatLng(latitude, longitude);

        mMap.addMarker(new MarkerOptions()
                .position(posicao)
                .snippet("Local do parque do ibirapuera")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ninja))
                .title(local));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(posicao,15));

        LatLng lugar = new LatLng(-23.702723, -46.6914657);


        //Criando Circulos
        CircleOptions circleOptions = new CircleOptions();

        circleOptions.center(lugar);
        circleOptions.fillColor(Color.argb(50,0,255,255));
        circleOptions.strokeWidth(10);
        circleOptions.strokeColor(Color.argb(50,47,79,79));
        //Medida em metros
        circleOptions.radius(500.00);
        //Aplicando o circulo no mapa
         mMap.addCircle(circleOptions);




        


    }
}