package group1.simplebloodbank;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import group1.simplebloodbank.model.BloodBank;
import group1.simplebloodbank.network.BloodBankNetworkListener;
import group1.simplebloodbank.network.NetworkManager;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback , BloodBankNetworkListener{

    private GoogleMap mMap;
    private List<BloodBank> mBloodBanks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        NetworkManager networkManager =  new NetworkManager();
        networkManager.setListener(this);
        networkManager.requestBloodBanks();
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
    }

    @Override
    public void onRequestCompleted(List<BloodBank> bloodBanks) {

        for (BloodBank bloodBank : bloodBanks) {
            setMapMarkers(bloodBank.getName(), bloodBank.getLatitude(), bloodBank.getLongitude());
        }

    }

    private void setMapMarkers(String name, float latitude, float longitude) {
        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title(name));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(latitude,longitude)));
    }

    @Override
    public void onRequestFailed(Throwable throwable) {
        throwable.printStackTrace();
    }
}
