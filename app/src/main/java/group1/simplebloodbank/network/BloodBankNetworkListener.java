package group1.simplebloodbank.network;

import java.util.List;

import group1.simplebloodbank.model.BloodBank;

/**
 * Created by abshirahmed on 30/12/2016.
 */
public interface BloodBankNetworkListener {
    void onRequestCompleted(List<BloodBank> bloodBanks);

    void onRequestFailed(Throwable throwable);
}
