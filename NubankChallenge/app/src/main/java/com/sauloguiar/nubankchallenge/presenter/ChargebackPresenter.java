package com.sauloguiar.nubankchallenge.presenter;

import android.util.Log;

import com.sauloguiar.nubankchallenge.data.Chargeback;
import com.sauloguiar.nubankchallenge.data.ChargebackRequest;
import com.sauloguiar.nubankchallenge.data.Status;
import com.sauloguiar.nubankchallenge.network.CommunicatorService;
import com.sauloguiar.nubankchallenge.ui.UiEvents;
import com.sauloguiar.nubankchallenge.ui.Views;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sauloaguiar on 3/21/16.
 */
public class ChargebackPresenter implements UiEvents.ChargebackScreenPresenter{

    private Views.ChargebackScreen chargebackScreenView;
    private CommunicatorService communicatorService;
    private ChargebackRequest chargebackRequest;

    public ChargebackPresenter(Views.ChargebackScreen chargebackScreenView, CommunicatorService communicator) {
        this.chargebackScreenView = chargebackScreenView;
        this.communicatorService = communicator;
        chargebackRequest = new ChargebackRequest();
    }

    @Override
    public void onVenueRecognized(boolean value) {

    }

    @Override
    public void onCardInPossession(boolean value) {

    }

    @Override
    public void onChargebackSubmit(boolean venueRecognized, boolean cardInPossesion, String comment) {
        chargebackRequest.setVenueRecognized(venueRecognized);
        chargebackRequest.setCardInPossesion(cardInPossesion);
        chargebackRequest.setComment(comment);

        chargebackScreenView.showProgress();
        communicatorService.postChargeback(chargebackRequest, new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                // check if call was successfull
                chargebackScreenView.hideProgress();
                if (response.isSuccess()) {
                    chargebackScreenView.chargebackSuccess();
                } else {
                    try {
                        chargebackScreenView.showFeedback(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                        chargebackScreenView.onFailure(e.getCause());
                    }
                }
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                chargebackScreenView.hideProgress();
                chargebackScreenView.showFeedback(t.toString());
            }
        });
    }

    @Override
    public void onChargebackCancelled() {

    }

    @Override
    public void blockCard() {
        chargebackScreenView.showProgress();
        communicatorService.postBlockCard(new Callback<Status>() {
            public void onResponse(Call<Status> call, Response<Status> response) {
                chargebackScreenView.hideProgress();
                if (response.isSuccess()) {
                    if (response.body().isOk()) {
                        chargebackScreenView.autoblockCard(true);
                    } else {
                        chargebackScreenView.autoblockCard(false);
                    }
                }
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                chargebackScreenView.hideProgress();
                chargebackScreenView.onFailure(t);

                Log.d("ChargebackPresenter", t.toString());
            }
        });
    }

    @Override
    public void unblockCard() {
        chargebackScreenView.showProgress();
        communicatorService.postUnblockCard(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                chargebackScreenView.hideProgress();
                if (response.isSuccess()) {
                    if (response.body().isOk()) {
                        chargebackScreenView.autoblockCard(true);
                    } else {
                        chargebackScreenView.autoblockCard(false);
                    }
                } else {
                    chargebackScreenView.showFeedback("Error within calling the server");
                }
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                chargebackScreenView.hideProgress();
                chargebackScreenView.onFailure(t);

                Log.d("ChargebackPresenter", t.toString());
            }
        });
    }

    @Override
    public void onStart() {
        chargebackScreenView.showProgress();
        communicatorService.getChargeback(new Callback<Chargeback>() {
            @Override
            public void onResponse(Call<Chargeback> call, Response<Chargeback> response) {
                chargebackScreenView.hideProgress();

                chargebackScreenView.setTitle(response.body().getTitle());
                chargebackScreenView.setCardInPossession(response.body().hasCard(), response.body().getCardInPossessionString());
                chargebackScreenView.setMerchantRecognized(response.body().merchantRecognized(), response.body().getMerchantRecognizedString());
                chargebackScreenView.setComment(response.body().getComment());
                chargebackScreenView.autoblockCard(response.body().getAutoblocked());
            }

            @Override
            public void onFailure(Call<Chargeback> call, Throwable t) {
                chargebackScreenView.hideProgress();
                chargebackScreenView.onFailure(t);

                Log.d("ChargebackPresenter", t.toString());
            }
        });
    }

    @Override
    public void onStop() {

    }
}
