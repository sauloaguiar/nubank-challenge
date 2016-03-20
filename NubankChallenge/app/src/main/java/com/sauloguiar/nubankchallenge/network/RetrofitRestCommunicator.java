package com.sauloguiar.nubankchallenge.network;

import com.google.gson.JsonElement;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sauloaguiar on 3/10/16.
 */
public class RetrofitRestCommunicator implements RestCommunicator {

    private NubankService.NubankEndpoint endpoint;
    private RestCommunicationListener listener;

    public RetrofitRestCommunicator(RestCommunicationListener listener) {
        // TODO Define interface that will receive data after the service is called

        endpoint = (new NubankService()).getApiEndpoint();
        this.listener = listener;
    }

    // TODO Define how to pass arguments to the call

    @Override
    public void get(String path, HashMap<String, String> args) {
        // TODO
        endpoint.getAction(path).enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                listener.onSuccess(response.body(), response.code());
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                listener.onFailure(t);
            }
        });

    }

    @Override
    public void post(String path, HashMap<String, String> args) {
        // TODO
        endpoint.postAction(path).enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                listener.onSuccess(response.body(), response.code());
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                listener.onFailure(t);
            }
        });
    }

        /*
    public String get(){



        Call<JsonElement> result = (new NubankService()).getApiEndpoint().;

        result.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                Log.d("Nubank", "onResponse: Body " + response.body());
                Log.d("Nubank", "onResponse: Message " + response.message());
                Log.d("Nubank", "onResponse: Code " + response.code());

                try {
                    JSONObject object = new JSONObject(response.body().toString());
                    Log.d("Nubank", "onResponse: Link " + object.getJSONObject("links").getJSONObject("notice").get("href"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.d("Nubank", "onFailure: " + t.getMessage());
            }
        });

        return "error";

    }*/

}
