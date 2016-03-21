package com.sauloguiar.nubankchallenge.network;

import java.util.HashMap;

/**
 * Created by sauloaguiar on 3/10/16.
 */
public interface RestCommunicator {

    // TODO Define test cases and mock webservice call

    void get(String path, HashMap<String, String> args, final RestCommunicationListener listener);
    void post(String path, HashMap<String, String> args, final RestCommunicationListener listener);
}
