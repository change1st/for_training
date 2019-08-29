package com.th.exception;

import java.io.Serializable;

/**
 * Created by tianhui on 16/9/17.
 */
public class JsonException extends RuntimeException implements Serializable {
    public JsonException(String message) {
        super(message);
    }

    public JsonException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
