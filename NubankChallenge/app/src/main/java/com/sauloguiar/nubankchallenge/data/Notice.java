package com.sauloguiar.nubankchallenge.data;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by sauloaguiar on 3/20/16.
 */
public class Notice {

    private String title;
    private String description;
    private Action primary_action;
    private Action secondary_action;
    private HashMap<String, JSONObject> links;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrimaryActionLabel() {
        return primary_action.title;
    }

    public String getSecondaryActionLabel() {
        return secondary_action.title;
    }

    class Action {
        String title;
        String action;
    }

}
