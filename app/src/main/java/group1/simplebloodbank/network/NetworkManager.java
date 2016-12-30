package group1.simplebloodbank.network;


import com.google.gson.Gson;

import group1.simplebloodbank.model.BloodBankWrapper;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    // sets up all client connection to retrieve JSON from remote server
    // Uses the GSON Converter Factory to convert JSON to POJO

    private Retrofit mRetrofit; //declared object mRetrofit of type Retrofit
    private BloodBankApi mBloodBankApi;
    private BloodBankNetworkListener mListener;

    public NetworkManager() {
// Set up the HTTP client with the logging interceptor
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(Level.BODY);
        builder.interceptors().add(loggingInterceptor);
        OkHttpClient httpClient = builder.build();

        // Create our retrofit client (a library that handles networking)
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://demo1619537.mockable.io/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();

        // Ask retrofit to create/generate an implementation for our bloodbank GET request
        mBloodBankApi = mRetrofit.create(BloodBankApi.class); //creates an a
    }

    public void setListener(BloodBankNetworkListener listener) {
        mListener = listener;
    }
    public void requestBloodBanks() {
        mBloodBankApi.getBloodBanks().enqueue(new Callback<BloodBankWrapper>() {
            @Override
            public void onResponse(Call<BloodBankWrapper> call, Response<BloodBankWrapper> response) {
                if (response != null && response.isSuccessful()) {
                    if (mListener != null) {
                        mListener.onRequestCompleted(response.body().getBloodbanks());
                    }
                }
            }

            @Override
            public void onFailure(Call<BloodBankWrapper> call, Throwable t) {
                if (mListener != null) {
                    mListener.onRequestFailed(t);
                }
            }
        });
    }
}
