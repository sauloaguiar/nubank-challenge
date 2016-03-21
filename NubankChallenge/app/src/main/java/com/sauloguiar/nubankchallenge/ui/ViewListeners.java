package com.sauloguiar.nubankchallenge.ui;

import com.google.gson.JsonElement;

/**
 * Created by sauloaguiar on 3/20/16.
 */
public interface ViewListeners {

    interface Base {
        void onFailure(Throwable t);
    }
    interface NoticeScreen extends Base{
        void update(JsonElement elements);
    }

    interface ChargebackScreen extends Base {
        void update(JsonElement elements);
    }

    interface DialogScreen extends Base{
        void update(JsonElement elements);
    }

}
