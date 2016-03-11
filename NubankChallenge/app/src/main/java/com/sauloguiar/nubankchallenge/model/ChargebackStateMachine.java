package com.sauloguiar.nubankchallenge.model;

import com.sauloguiar.nubankchallenge.ui.UiEvents;

/**
 * Created by sauloaguiar on 3/10/16.
 */
public interface ChargebackStateMachine extends UiEvents.Handling {
    ChargebackState getState();
    void updateView();
}
