package com.sauloguiar.nubankchallenge.model;

import com.google.gson.JsonElement;
import com.sauloguiar.nubankchallenge.ui.UiUpdateListener;

/**
 * Created by sauloaguiar on 3/19/16.
 */
public class ChargebackStateMachineImpl implements ChargebackStateMachine {

    private UiUpdateListener listener;
    private ChargebackState state;


    public ChargebackStateMachineImpl(UiUpdateListener listener) {
        this.listener = listener;
    }

    // Transitions
    private void toNoticeState(){ setState(NOTICE); }
    private void toChargebackState() { setState(CHARGEBACK);  }

    private void setState(ChargebackState state) {
        if (this.state != null) {
            this.state.onExit();
        }
        this.state = state;

        updateView();

        this.state.onEntry();

    }

    // States
    private ChargebackState NOTICE = new ChargebackState() {
        @Override
        public void onEntry() {

        }

        @Override
        public void onExit() {

        }

        @Override
        public String getStateName() {
            return null;
        }

        @Override
        public void updateView() {
            listener.updateNoticeScreen();
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
        public void onDialogDismissed() {

        }

        @Override
        public void onContinue() {

        }

        @Override
        public void onNoticeCancelled() {

        }

        @Override
        public void onSuccess(JsonElement element, int responseCode) {

        }

        @Override
        public void onFailure(Throwable throwable) {

        }
    };

    private ChargebackState CHARGEBACK = new ChargebackState() {
        @Override
        public void onEntry() {

        }

        @Override
        public void onExit() {

        }

        @Override
        public String getStateName() {
            return null;
        }

        @Override
        public void updateView() {
            listener.updateChargebackScreen();
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
        public void onDialogDismissed() {

        }

        @Override
        public void onContinue() {

        }

        @Override
        public void onNoticeCancelled() {

        }

        @Override
        public void onSuccess(JsonElement element, int responseCode) {

        }

        @Override
        public void onFailure(Throwable throwable) {

        }
    };

    // State Machine Events
    @Override
    public ChargebackState getState() {
        return this.state;
    }

    @Override
    public void updateView() {
        this.state.updateView();
    }

    @Override
    public void actionInit() {
        toNoticeState();
    }

    // Chargeback Screen events
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

    // Dialog Screen Events
    @Override
    public void onDialogDismissed() {

    }

    // Notice Screen Events
    @Override
    public void onContinue() {
        toChargebackState();
    }

    @Override
    public void onNoticeCancelled() {
        // deallocate resources
    }

}
