package com.sauloguiar.nubankchallenge.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sauloaguiar on 3/21/16.
 */
public class ChargebackRequest {

    private transient final String RESPONSE = "response";
    private transient final String MERCHANT_RECOGNIZED = "merchant_recognized";
    private transient final String ID = "id";
    private transient final String CARD_IN_POSSESSION = "card_in_possession";

    private String comment;
    private List<HashMap<String, Object>> reason_details;

    private transient boolean venueRecognized;
    private transient boolean cardInPossesion;

    public List getReasonDetailList() {
        return reason_details;
    }

    public String getComment() {
        return comment;
    }

    class Details {
        String id;
        boolean response;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Details details = (Details) o;
            return id.equals(details.id);
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }

    public ChargebackRequest() {
        reason_details = new ArrayList<>();

    }

    public void setVenueRecognized(boolean venueRecognized) {
        this.venueRecognized = venueRecognized;
        HashMap<String, Object> object = find(MERCHANT_RECOGNIZED);
        if (object != null) {
            object.put(RESPONSE, venueRecognized);
        } else {
            HashMap<String, Object> obj = new HashMap<>();
            obj.put(ID, MERCHANT_RECOGNIZED);
            obj.put(RESPONSE, venueRecognized);
            reason_details.add(obj);
        }
    }

    private HashMap<String, Object> find(String value) {
        for (HashMap<String, Object> object : reason_details) {
            if (object.containsValue(value)) {
                return object;
            }
        }
        return null;
    }


    public void setCardInPossesion(boolean cardInPossesion) {
        this.cardInPossesion = cardInPossesion;
        HashMap<String, Object> object = find(CARD_IN_POSSESSION);
        if (object != null) {
            object.put(RESPONSE, cardInPossesion);
        } else {
            HashMap<String, Object> obj = new HashMap<>();
            obj.put(ID, CARD_IN_POSSESSION);
            obj.put(RESPONSE, cardInPossesion);
            reason_details.add(obj);
        }
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
