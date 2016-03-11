package com.sauloguiar.nubankchallenge.network;

/**
 * Created by sauloaguiar on 3/10/16.
 */
public interface RestCommunicator {

    // TODO Define test cases and mock webservice call
    
    void get(String path, String... args);
    void post(String path, String... args);
}
