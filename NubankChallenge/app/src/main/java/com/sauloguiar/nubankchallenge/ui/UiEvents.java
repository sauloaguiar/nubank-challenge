package com.sauloguiar.nubankchallenge.ui;

/**
 * Created by sauloaguiar on 3/10/16.
 */
public interface UiEvents {

    interface Base {
        void onStart();
        void onStop();
    }
    interface NoticeScreenPresenter extends Base {
        void onContinue();
        void onNoticeCancelled();
    }

    interface ChargebackScreenPresenter extends Base {
        void onVenueRecognized(boolean value);
        void onCardInPossession(boolean value);
        void onChargebackSubmit(boolean venueRecognized, boolean cardInPossesion, String comment);
        void onChargebackCancelled();

        void blockCard();
        void unblockCard();

    }

    interface DialogScreenPresenter {
        void onDialogDismissed();
    }

    interface AllPresenters extends NoticeScreenPresenter, ChargebackScreenPresenter, DialogScreenPresenter {

    }
}
