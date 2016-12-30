package group1.simplebloodbank;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import group1.simplebloodbank.model.BloodBank;
import group1.simplebloodbank.model.BloodBankWrapper;
import group1.simplebloodbank.network.BloodBankNetworkListener;
import group1.simplebloodbank.network.NetworkManager;

public class MainActivity extends AppCompatActivity implements BloodBankNetworkListener {

    private TextView mTxtRawData;
    private List<BloodBank> mBloodBanks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtRawData = (TextView) findViewById(R.id.txt_bloodbank_raw_data);

        NetworkManager networkManager =  new NetworkManager();
        networkManager.setListener(this);
        networkManager.requestBloodBanks();
    }

    @Override
    public void onRequestCompleted(List<BloodBank> bloodBanks) {
        // TODO: now we can do things with our bloodBanks object. This is where we
        // now have our data fom the network to pass around the app and use as we wish.

        Log.i(getClass().getCanonicalName(), "Our data from the network: " + bloodBanks.toString());
        mTxtRawData.setText(bloodBanks.toString());
    }

    @Override
    public void onRequestFailed(Throwable throwable) {

    }
}
