package com.sauloguiar.nubankchallenge.data;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by sauloaguiar on 3/21/16.
 */
public class ChargebackRequestTest {

    private ChargebackRequest instance;

    @Before
    public void setUp(){
        instance = new ChargebackRequest();
    }

    @Test
    public void shouldInsertVenueRecognized() throws Exception {
        instance.setVenueRecognized(true);
        List<HashMap<String, Object>> list = instance.getReasonDetailList();
        for (HashMap<String, Object> elem : list) {
            if (elem.containsValue("merchant_recognized")) {
                assertEquals((Boolean) elem.get("response"), Boolean.TRUE);
                return;
            }
        }
    }

    @Test
    public void shouldUpdateVenueRecognized() {
        instance.setVenueRecognized(true);
        List<HashMap<String, Object>> list = instance.getReasonDetailList();
        for (HashMap<String, Object> elem : list) {
            if (elem.containsValue("merchant_recognized")) {
                assertEquals((Boolean) elem.get("response"), Boolean.TRUE);
                return;
            }
        }
        instance.setVenueRecognized(false);
        list = instance.getReasonDetailList();
        for (HashMap<String, Object> elem : list) {
            if (elem.containsValue("merchant_recognized")) {
                assertEquals((Boolean) elem.get("response"), Boolean.FALSE);
                return;
            }
        }
    }

    @Test
    public void shouldInsertCardInPossession() {
        instance.setCardInPossesion(true);
        List<HashMap<String, Object>> list = instance.getReasonDetailList();
        for (HashMap<String, Object> elem : list) {
            if (elem.containsValue("card_in_possession")) {
                assertEquals((Boolean) elem.get("response"), true);
                return;
            }
        }
    }

    @Test
    public void shouldUpdateCardInPossession(){
        instance.setCardInPossesion(true);
        List<HashMap<String, Object>> list = instance.getReasonDetailList();
        for (HashMap<String, Object> elem : list) {
            if (elem.containsValue("card_in_possession")) {
                assertEquals((Boolean) elem.get("response"), true);
                return;
            }
        }
        instance.setCardInPossesion(false);
        list = instance.getReasonDetailList();
        for (HashMap<String, Object> elem : list) {
            if (elem.containsValue("card_in_possession")) {
                assertEquals((Boolean) elem.get("response"), false);
                return;
            }
        }
    }

    @Test
    public void shouldSetComment(){
        String comment = "test comment";
        instance.setComment(comment);
        assertEquals(comment, instance.getComment());

    }
}