package com.grz55.studentsliquibase.exception;

public class TokenNotTrustedException extends RuntimeException {

    public TokenNotTrustedException(String token) {
        super("Token " + token + " cannot be trusted");
    }

}
