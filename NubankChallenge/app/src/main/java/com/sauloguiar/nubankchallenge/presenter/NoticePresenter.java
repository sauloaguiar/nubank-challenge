package com.sauloguiar.nubankchallenge.presenter;

import com.sauloguiar.nubankchallenge.data.Notice;
import com.sauloguiar.nubankchallenge.network.NubankService;
import com.sauloguiar.nubankchallenge.network.RestCommunicator;
import com.sauloguiar.nubankchallenge.network.RetrofitRestCommunicator;
import com.sauloguiar.nubankchallenge.ui.UiEvents;
import com.sauloguiar.nubankchallenge.ui.Views;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by sauloaguiar on 3/20/16.
 */
public class NoticePresenter implements UiEvents.NoticeScreenPresenter {

    private Views.NoticeScreen noticeScreenView;
    private RestCommunicator communicator;

    public NoticePresenter(Views.NoticeScreen noticeScreenView) {
        this.noticeScreenView = noticeScreenView;
        communicator = new RetrofitRestCommunicator();
    }

    @Override
    public void onContinue() {

    }

    @Override
    public void onNoticeCancelled() {

    }

    @Override
    public void onStart() {
        noticeScreenView.showProgress();
        NubankService.NubankEndpoint endpoint = (new NubankService()).getApiEndpoint();
        endpoint.getNotice().enqueue(new Callback<Notice>() {
            @Override
            public void onResponse(Call<Notice> call, Response<Notice> response) {
                noticeScreenView.hideProgress();

                noticeScreenView.setTitle(response.body().getTitle());
                noticeScreenView.setDescription(response.body().getDescription());
                noticeScreenView.setContinueButtonLabel(response.body().getPrimaryActionLabel());
                noticeScreenView.setCancelButtonLabel(response.body().getSecondaryActionLabel());
            }

            @Override
            public void onFailure(Call<Notice> call, Throwable t) {
                noticeScreenView.hideProgress();
                
                noticeScreenView.onFailure(t);
            }
        });
    }

    @Override
    public void onStop() {

    }
}
