package com.example.springapitest.exception.merchanr;

public class MerchantNotFoundException extends Exception {

    private static final long serialVersionUID = -9079454849611061074L;

    public MerchantNotFoundException() {
        super();
    }

    public MerchantNotFoundException(final String message) {
        super(message);
    }
}
