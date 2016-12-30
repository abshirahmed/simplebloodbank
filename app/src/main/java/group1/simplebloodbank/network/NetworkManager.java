package group1.simplebloodbank.network;


import com.google.gson.Gson;

import group1.simplebloodbank.model.BloodBankWrapper;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    private Retrofit mRetrofit;

    public NetworkManager() {

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(Level.BODY);
        builder.interceptors().add(loggingInterceptor);
        OkHttpClient httpClient = builder.build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://demo1619537.mockable.io/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();
    }

    public BloodBankWrapper getBloodBanks() {
        mRetrofit; //TODO:
    }
}
