package com.sauloguiar.nubankchallenge.data;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

/**
 * Created by sauloaguiar on 3/20/16.
 */
public class Chargeback {

    private String comment_hint;
    private String id;
    private String title;

    private boolean autoblock;

    private List<Detail> reason_details;

    private HashMap<String, JSONObject> links;

    class Detail {
        String id;
        String title;
    }

    public String getTitle() {
        return title;
    }


    public String getCardInPossessionString() {
        for (Detail element : reason_details) {
            if (element.id.equals("card_in_possession")) {
                return element.title;
            }
        }
        return "Error processing JSON";
    }

    public boolean getAutoblocked() {
        return autoblock;
    }

    public boolean hasCard() {
        return !getAutoblocked();
    }

    public boolean merchantRecognized() {
        return !getAutoblocked();
    }

    public String getComment() {
        return comment_hint;
    }

    public String getMerchantRecognizedString() {
        for (Detail element : reason_details) {
            if (element.id.equals("merchant_recognized")) {
                return element.title;
            }
        }
        return "Error processing JSON";
    }
}
