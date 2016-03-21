package com.sauloguiar.nubankchallenge.presenter;

import com.sauloguiar.nubankchallenge.network.CommunicatorService;
import com.sauloguiar.nubankchallenge.ui.UiEvents;
import com.sauloguiar.nubankchallenge.ui.Views;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by sauloaguiar on 3/21/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class NoticePresenterTest extends TestCase {

    private UiEvents.NoticeScreenPresenter presenter;

    @Mock
    private Views.NoticeScreen noticeScreenView;

    @Mock
    private CommunicatorService communicator;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        presenter = new NoticePresenter(noticeScreenView, communicator);
    }

    @Test
    public void shouldShowProgressAfterStart() throws Exception {
        presenter.onStart();
        verify(noticeScreenView).showProgress();
    }

}