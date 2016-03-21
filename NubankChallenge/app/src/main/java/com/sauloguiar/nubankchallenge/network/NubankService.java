package com.sauloguiar.nubankchallenge.network;

import com.google.gson.Gson;
import com.sauloguiar.nubankchallenge.data.Chargeback;
import com.sauloguiar.nubankchallenge.data.Notice;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by sauloaguiar on 3/10/16.
 */
public class NubankService {

    public interface NubankEndpoint {
        @GET("/notice")
        public Call<Notice> getNotice();

        @GET("/chargeback")
        public Call<Chargeback> getChargeback();

        @POST("/block_card")
        public Call<JSONObject> postBlockCard();

        @POST("/unblock_card")
        public Call<JSONObject> postUnblockCard();

        @POST("/chargeback")
        public Call<JSONObject> postChargeback();
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
