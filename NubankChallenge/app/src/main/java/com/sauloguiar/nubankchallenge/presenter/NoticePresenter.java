package com.sauloguiar.nubankchallenge.presenter;

import com.sauloguiar.nubankchallenge.data.Notice;
import com.sauloguiar.nubankchallenge.network.CommunicatorService;
import com.sauloguiar.nubankchallenge.ui.UiEvents;
import com.sauloguiar.nubankchallenge.ui.Views;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by sauloaguiar on 3/20/16.
 */
public class NoticePresenter implements UiEvents.NoticeScreenPresenter {

    private CommunicatorService communicatorService;
    private Views.NoticeScreen noticeScreenView;

    public NoticePresenter(Views.NoticeScreen noticeScreenView, CommunicatorService communicator) {
        this.noticeScreenView = noticeScreenView;
        this.communicatorService = communicator;
    }

    @Override
    public void onContinue() {

    }

    @Override
    public void onNoticeCancelled() {
        onStop();
    }

    @Override
    public void onStart() {
        noticeScreenView.showProgress();
        communicatorService.getNotice(new Callback<Notice>() {
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
        this.noticeScreenView = null;
        this.communicatorService = null;
    }
}
