package group1.simplebloodbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import group1.simplebloodbank.model.BloodBank;
import group1.simplebloodbank.model.BloodBankWrapper;
import group1.simplebloodbank.network.NetworkManager;

public class MainActivity extends AppCompatActivity {

    private BloodBankWrapper mBloodBanks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NetworkManager networkManager =  new NetworkManager();

        mBloodBanks = networkManager.getBloodBanks();

        for (BloodBank bloodBank : mBloodBanks.getBloodbanks()) {
            bloodBank.getBloodType().getAbPositive();
        }
    }
}
