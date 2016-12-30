package group1.simplebloodbank.model;


public class BloodBank {

    private String name;
    private String postcode;
    private float latitude;
    private float longitude;
    private BloodType bloodType;

    public String getName() {
        return name;
    }

    public String getPostcode() {
        return postcode;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

}