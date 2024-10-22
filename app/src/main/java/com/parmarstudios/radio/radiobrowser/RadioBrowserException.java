package com.parmarstudios.radio.radiobrowser;

/**
 * Exception in radio browser communication.
 *
 * @author Manish Parmar
 */
public class RadioBrowserException extends RuntimeException {

    /**
     * Constructs an exception from an error message.
     *
     * @param message the error message for this exception.
     */
    public RadioBrowserException(final String message) {
        super(message);
    }

    /**
     * Constructs an exception from another exception
     * which is the cause.
     *
     * @param inner the cause of this exception.
     */
    public RadioBrowserException(final Throwable inner) {
        super(inner);
    }
}
