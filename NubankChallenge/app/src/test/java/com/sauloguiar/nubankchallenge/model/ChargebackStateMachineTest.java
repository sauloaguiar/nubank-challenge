package com.sauloguiar.nubankchallenge.model;

import com.sauloguiar.nubankchallenge.ui.UiUpdateListener;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by sauloaguiar on 3/19/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ChargebackStateMachineTest {


    @Mock
    UiUpdateListener listener;

    ChargebackStateMachine machine;

    @Before
    public void setUp() throws Exception {
        machine = new ChargebackStateMachineImpl(listener);
    }

    @Test
    public void shouldHaveANonNullStateAfterInit() {
        machine.actionInit();
        assert(machine.getState() != null);

        verify(listener).updateNoticeScreen();
    }

    @Test
    public void shouldUpdateScreenAfterGotIntoChargebackState() throws Exception {
        machine.actionInit();

        machine.onContinue();
        verify(listener).updateChargebackScreen();
    }

    @Test
    public void shouldUpdateNoticeScreenAfterComingBackFromChargeback() throws Exception {
        machine.actionInit();

        machine.onContinue();
        verify(listener).updateChargebackScreen();

        machine.onChargebackCancelled();
        verify(listener).updateNoticeScreen();

    }
}
