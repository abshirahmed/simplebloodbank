package group1.simplebloodbank.model;

import java.util.Collections;
import java.util.List;

//contains a single element which is a list of bloodbanks obtained from JSON (http://demo1619537.mockable.io/bloodbank)

public class BloodBankWrapper {

    private List<BloodBank> bloodbanks = Collections.emptyList();

    public List<BloodBank> getBloodbanks() {
        return bloodbanks;
    }

    @Override
    public String toString() {
        return "BloodBankWrapper{" +
                "bloodbanks=" + bloodbanks +
                '}';
    }
}