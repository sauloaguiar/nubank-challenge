package com.sauloguiar.nubankchallenge.ui;

/**
 * Created by sauloaguiar on 3/20/16.
 */
public interface Views {

    interface Base {
        public void showProgress();
        public void hideProgress();
        public void onFailure(Throwable t);

        public void setTitle(String title);

    }

    interface NoticeScreen extends Base {
        public void setDescription(String description);
        public void setContinueButtonLabel(String label);
        public void setCancelButtonLabel(String label);
    }

    interface ChargebackScreen extends Base {
        public void setMerchantRecognized(boolean bool, String label);
        public void setCardInPossession(boolean bool, String label);
        public void autoblockCard(boolean bool);

        public void setComment(String comment);

    }


}
