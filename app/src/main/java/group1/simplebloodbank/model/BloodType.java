package group1.simplebloodbank.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BloodType {

    @SerializedName("o_positive")
    private int oPositive;
    @SerializedName("o_negative")
    private int oNegative;
    @SerializedName("a_positive")
    private int aPositive;
    @SerializedName("a_negative")
    private int aNegative;
    @SerializedName("b_positive")
    private int bPositive;
    @SerializedName("b_negative")
    private int bNegative;
    @SerializedName("ab_positive")
    private int abPositive;
    @SerializedName("ab_negative")
    private int abNegative;

    public int getoPositive() {
        return oPositive;
    }

    public int getoNegative() {
        return oNegative;
    }

    public int getaPositive() {
        return aPositive;
    }

    public int getaNegative() {
        return aNegative;
    }

    public int getbPositive() {
        return bPositive;
    }

    public int getbNegative() {
        return bNegative;
    }

    public int getAbPositive() {
        return abPositive;
    }

    public int getAbNegative() {
        return abNegative;
    }

    @Override
    public String toString() {
        return "BloodType{" +
                "oPositive=" + oPositive +
                ", oNegative=" + oNegative +
                ", aPositive=" + aPositive +
                ", aNegative=" + aNegative +
                ", bPositive=" + bPositive +
                ", bNegative=" + bNegative +
                ", abPositive=" + abPositive +
                ", abNegative=" + abNegative +
                '}';
    }
}
