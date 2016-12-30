package group1.simplebloodbank.model;


public class BloodBank {

    private String name;
    private String postcode;
    private float latitude;
    private float longitude;
    private BloodType bloodtype;

    //assigning getters to return required fields
    public String getName() { return name; }

    public String getPostcode() { return postcode;}

    public float getLatitude() { return latitude; }

    public float getLongitude() { return longitude; }

    public BloodType getBloodtype() { return bloodtype; }

    @Override
    public String toString() {
        return "BloodBank{" +
                "name='" + name + '\'' +
                ", postcode='" + postcode + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", bloodtype=" + bloodtype +
                '}';
    }
}