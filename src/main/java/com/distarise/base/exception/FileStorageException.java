package com.distarise.base.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileStorageException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(FileStorageException.class);
    public FileStorageException(String message) {
        super(message);
        logger.debug(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
        logger.debug(message, cause);
    }
}