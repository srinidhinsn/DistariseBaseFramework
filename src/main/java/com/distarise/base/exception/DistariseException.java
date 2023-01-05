package com.distarise.base.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DistariseException extends RuntimeException{
    private static final Logger logger = LoggerFactory.getLogger(DistariseException.class);
    private String message;

    public DistariseException(String message) {
        super(message);
        this.message = message;
        logger.debug(message);
    }

    public DistariseException(Throwable cause, String message) {
        super(cause);
        this.message = message;
        logger.debug(message);
    }
}
