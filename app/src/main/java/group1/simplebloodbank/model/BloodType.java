package group1.simplebloodbank.model;

import com.google.gson.annotations.SerializedName;

public class BloodType {

    @SerializedName("o_positive")
    public int oPositive;
    @SerializedName("o_negative")
    public int oNegative;
    @SerializedName("a_positive")
    public int aPositive;
    @SerializedName("a_negative")
    public int aNegative;
    @SerializedName("b_positive")
    public int bPositive;
    @SerializedName("b_negative")
    public int bNegative;
    @SerializedName("ab_positive")
    public int abPositive;
    @SerializedName("ab_negative")
    public int abNegative;

}
