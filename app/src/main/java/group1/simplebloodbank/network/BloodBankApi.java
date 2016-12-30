package group1.simplebloodbank.network;


import group1.simplebloodbank.model.BloodBankWrapper;
import retrofit2.Call;
import retrofit2.http.GET;

interface BloodBankApi {

    @GET("bloodbank")
    Call<BloodBankWrapper> getBloodBanks();

}
