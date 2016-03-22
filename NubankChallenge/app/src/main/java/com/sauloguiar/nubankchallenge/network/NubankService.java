package com.sauloguiar.nubankchallenge.network;

import com.google.gson.Gson;
import com.sauloguiar.nubankchallenge.data.Chargeback;
import com.sauloguiar.nubankchallenge.data.ChargebackRequest;
import com.sauloguiar.nubankchallenge.data.Notice;
import com.sauloguiar.nubankchallenge.data.Status;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by sauloaguiar on 3/10/16.
 */
public class NubankService implements CommunicatorService {

    @Override
    public void getNotice(final Callback<Notice> callback) {
        endpoint.getNotice().enqueue(new Callback<Notice>() {
            @Override
            public void onResponse(Call<Notice> call, Response<Notice> response) {
                callback.onResponse(call, response);
            }

            @Override
            public void onFailure(Call<Notice> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }

    @Override
    public void postBlockCard(final Callback<Status> callback) {
        endpoint.postBlockCard().enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                callback.onResponse(call, response);
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }

    @Override
    public void postUnblockCard(final Callback<Status> callback) {
        endpoint.postUnblockCard().enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                callback.onResponse(call, response);
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }

    @Override
    public void getChargeback(final Callback<Chargeback> callback) {
        endpoint.getChargeback().enqueue(new Callback<Chargeback>() {
            @Override
            public void onResponse(Call<Chargeback> call, Response<Chargeback> response) {
                callback.onResponse(call, response);
            }

            @Override
            public void onFailure(Call<Chargeback> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }

    @Override
    public void postChargeback(ChargebackRequest request, final Callback<Status> callback) {
        endpoint.postChargeback(request).enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                callback.onResponse(call, response);
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }


    public interface NubankEndpoint {
        @GET("/notice")
        public Call<Notice> getNotice();

        @GET("/chargeback")
        public Call<Chargeback> getChargeback();

        @POST("/block_card")
        public Call<Status> postBlockCard();

        @POST("/card_unblock")
        public Call<Status> postUnblockCard();

        @POST("/chargeback")
        public Call<Status> postChargeback(@Body ChargebackRequest request);
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
