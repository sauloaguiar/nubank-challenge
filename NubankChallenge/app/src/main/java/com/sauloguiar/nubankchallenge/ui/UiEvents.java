package com.sauloguiar.nubankchallenge.ui;

/**
 * Created by sauloaguiar on 3/10/16.
 */
public interface UiEvents {

    interface NoticeScreen {
        void onContinue();
        void onCancel();
    }

    interface ChargebackScreen {
        void onVenueRecognized(boolean value);
        void onCardInPossession(boolean value);
        void onChargebackSubmit(boolean venueRecognized, boolean cardInPossesion);
        void onCancel();
    }

    interface DialogScreen {
        void onDialogDismissed();
    }

    interface Handling extends NoticeScreen, ChargebackScreen, DialogScreen {

    }
}
