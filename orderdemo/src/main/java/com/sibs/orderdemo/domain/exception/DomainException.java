package com.sibs.orderdemo.domain.exception;

/**
 * Domain exception class.
 */
public class DomainException extends RuntimeException {
    public DomainException(final String message){
        super(message);
    }
}
