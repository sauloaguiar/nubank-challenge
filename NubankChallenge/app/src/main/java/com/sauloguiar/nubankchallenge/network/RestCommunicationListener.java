package com.sauloguiar.nubankchallenge.network;

import com.google.gson.JsonElement;

/**
 * Created by sauloaguiar on 3/10/16.
 */
public interface RestCommunicationListener {
    void onSuccess(JsonElement element, int responseCode);
    void onFailure(Throwable throwable);
}
