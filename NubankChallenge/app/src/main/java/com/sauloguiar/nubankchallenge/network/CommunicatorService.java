package com.sauloguiar.nubankchallenge.network;

import com.sauloguiar.nubankchallenge.data.Chargeback;
import com.sauloguiar.nubankchallenge.data.ChargebackRequest;
import com.sauloguiar.nubankchallenge.data.Notice;
import com.sauloguiar.nubankchallenge.data.Status;

import retrofit2.Callback;

/**
 * Created by sauloaguiar on 3/21/16.
 */
public interface CommunicatorService {
    public void getNotice(Callback<Notice> callback);

    public void postBlockCard(Callback<Status> callback);


    public void postUnblockCard(Callback<Status> callback);

    public void getChargeback(Callback<Chargeback> callback);

    public void postChargeback(ChargebackRequest request, Callback<Status> callback);
}
