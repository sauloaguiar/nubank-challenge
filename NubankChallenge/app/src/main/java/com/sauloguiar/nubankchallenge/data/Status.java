package com.sauloguiar.nubankchallenge.data;

/**
 * Created by sauloaguiar on 3/21/16.
 */
public class Status {
    private String status;

    public boolean isOk() {
        return status.equalsIgnoreCase("ok");
    }
}
