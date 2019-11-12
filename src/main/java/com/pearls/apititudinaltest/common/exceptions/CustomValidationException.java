package com.pearls.apititudinaltest.common.exceptions;

public class CustomValidationException extends RuntimeException {

    private static final long serialVersionUID = -4331660954184219129L;

    private String userMsg;

    public CustomValidationException(String userMsg) {
        super(userMsg);
        this.userMsg = userMsg;
    }

    public CustomValidationException(String userMsg, String message) {
        super(message);
        this.userMsg = userMsg;
    }

    public CustomValidationException(String userMsg, String message, Throwable cause) {
        super(message, cause);
        this.userMsg = userMsg;
    }

    public String getUserMsg() {
        return userMsg;
    }

}
