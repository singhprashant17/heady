package com.exmaple.heady.webservice;

public class NoInternetException extends RuntimeException {

    public NoInternetException() {
        super("No Internet connection");
    }
}
