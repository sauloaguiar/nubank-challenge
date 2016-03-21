package com.sauloguiar.nubankchallenge.data;

import java.util.HashMap;
import java.util.List;

/**
 * Created by sauloaguiar on 3/21/16.
 */
public class ChargebackRequest {
    private String comment;
    private List<HashMap<String, Boolean>> reason_details;

    private transient boolean venueRecognized;
    private transient boolean cardInPossesion;

    public void setVenueRecognized(boolean venueRecognized) {
        this.venueRecognized = venueRecognized;
    }

    public void setCardInPossesion(boolean cardInPossesion) {
        this.cardInPossesion = cardInPossesion;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
