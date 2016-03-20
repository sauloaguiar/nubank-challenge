package com.sauloguiar.nubankchallenge.ui;

/**
 * Created by sauloaguiar on 3/10/16.
 */
public interface UiEvents {

    interface NoticeScreen {
        void onContinue();
        void onNoticeCancelled();
    }

    interface ChargebackScreen {
        void onVenueRecognized(boolean value);
        void onCardInPossession(boolean value);
        void onChargebackSubmit(boolean venueRecognized, boolean cardInPossesion);
        void onChargebackCancelled();
    }

    interface DialogScreen {
        void onDialogDismissed();
    }

    interface Handling extends NoticeScreen, ChargebackScreen, DialogScreen {

    }
}
