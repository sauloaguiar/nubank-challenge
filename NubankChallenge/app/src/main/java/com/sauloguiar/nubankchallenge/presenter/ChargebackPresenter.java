package com.sauloguiar.nubankchallenge.presenter;

import android.util.Log;

import com.sauloguiar.nubankchallenge.data.Chargeback;
import com.sauloguiar.nubankchallenge.network.NubankService;
import com.sauloguiar.nubankchallenge.ui.UiEvents;
import com.sauloguiar.nubankchallenge.ui.Views;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sauloaguiar on 3/21/16.
 */
public class ChargebackPresenter implements UiEvents.ChargebackScreenPresenter{

    private final Views.ChargebackScreen chargebackScreenView;

    public ChargebackPresenter(Views.ChargebackScreen chargebackScreenView) {
        this.chargebackScreenView = chargebackScreenView;
    }

    @Override
    public void onVenueRecognized(boolean value) {

    }

    @Override
    public void onCardInPossession(boolean value) {

    }

    @Override
    public void onChargebackSubmit(boolean venueRecognized, boolean cardInPossesion) {

    }

    @Override
    public void onChargebackCancelled() {

    }

    @Override
    public void blockCard() {
        chargebackScreenView.showProgress();
        NubankService.NubankEndpoint endpoint = (new NubankService()).getApiEndpoint();
        endpoint.postBlockCard().enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                chargebackScreenView.hideProgress();

                try {
                    if (response.body().getString("status").equals("ok")) {
                        chargebackScreenView.autoblockCard(true);
                    } else {
                        chargebackScreenView.autoblockCard(false);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {

            }
        });
    }

    @Override
    public void unblockCard() {

    }

    @Override
    public void onStart() {
        chargebackScreenView.showProgress();
        NubankService.NubankEndpoint endpoint = (new NubankService()).getApiEndpoint();
        endpoint.getChargeback().enqueue(new Callback<Chargeback>() {
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
