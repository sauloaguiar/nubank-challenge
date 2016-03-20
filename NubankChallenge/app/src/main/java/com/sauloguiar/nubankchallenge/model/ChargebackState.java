package com.sauloguiar.nubankchallenge.model;

import com.sauloguiar.nubankchallenge.network.RestCommunicationListener;
import com.sauloguiar.nubankchallenge.ui.UiEvents;

/**
 * Created by sauloaguiar on 3/10/16.
 */
public interface ChargebackState extends UiEvents.Handling, RestCommunicationListener {
    public void onEntry();
    public void onExit();
    public String getStateName();
    public void updateView();
}