package com.sauloguiar.nubankchallenge.facade;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sauloguiar.nubankchallenge.network.RestCommunicationListener;
import com.sauloguiar.nubankchallenge.network.RestCommunicator;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by sauloaguiar on 3/20/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ChargebackFacadeTest extends TestCase {

    //private ChargebackModel machine;

    @Mock
    private RestCommunicator communicator;

    @Mock
    private RestCommunicationListener restListener;

    @Captor
    private ArgumentCaptor<RestCommunicationListener> captorListener;

    @Before
    public void setUp() throws Exception {
        //machine = new ChargebackFacade(listener, communicator);
    }

    @Test
    public void shouldInitStateMachineAccordingly() throws Exception {
        JsonElement elem = (new JsonParser()).parse("");
        verify(communicator, times(1)).get(eq("notice"), any(HashMap.class), captorListener.capture());
        captorListener.getValue().onSuccess(elem, 200);

        //verify(listener).updateNoticeScreen(elem);
    }

    @Test
    public void shouldUpdateNoticeScreen() throws Exception {

        JsonElement elem = (new JsonParser()).parse("");
        verify(communicator, times(1)).get(eq("notice"), any(HashMap.class), captorListener.capture());
        captorListener.getValue().onSuccess(elem, 200);

        //verify(listener).updateNoticeScreen(elem);
    }

}