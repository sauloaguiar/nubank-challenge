package com.sauloguiar.nubankchallenge.network;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.sauloguiar.nubankchallenge.data.Chargeback;
import com.sauloguiar.nubankchallenge.data.Notice;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by sauloaguiar on 3/10/16.
 */
public class NubankService {

    public interface NubankEndpoint {
        @GET("/{endpoint}")
        public Call<JsonElement> getAction(@Path("endpoint") String endpoint);

        @POST("/{endpoint}")
        public Call<JsonElement> postAction(@Path("endpoint") String endpoint);

        @GET("/notice")
        public Call<Notice> getNotice();

        @GET("/chargeback")
        public Call<Chargeback> getChargeback();
    }

    private final String base_url = "https://nu-mobile-hiring.herokuapp.com/";
    private NubankEndpoint endpoint;

    public NubankService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(client)
                .build();

        endpoint = retrofit.create(NubankEndpoint.class);
    }

    public NubankEndpoint getApiEndpoint(){
        return endpoint;
    }

}
