package com.subbu.estore.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.nio.charset.Charset;

/**
 * Created by subbu on 22/02/18.
 */
public class UserNotFoundException extends HttpClientErrorException {


    /**
     * Construct a new instance of {@code HttpClientErrorException} based on
     * an {@link HttpStatus}.
     *
     * @param statusCode the status code
     */
    public UserNotFoundException(HttpStatus statusCode) {
        super(statusCode);
    }

    /**
     * Construct a new instance of {@code HttpClientErrorException} based on
     * an {@link HttpStatus} and status text.
     *
     * @param statusCode the status code
     * @param statusText the status text
     */
    public UserNotFoundException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }

    /**
     * Construct a new instance of {@code HttpClientErrorException} based on
     * an {@link HttpStatus}, status text, and response body content.
     *
     * @param statusCode      the status code
     * @param statusText      the status text
     * @param responseBody    the response body content (may be {@code null})
     * @param responseCharset the response body charset (may be {@code null})
     */
    public UserNotFoundException(HttpStatus statusCode, String statusText, byte[] responseBody, Charset responseCharset) {
        super(statusCode, statusText, responseBody, responseCharset);
    }

    /**
     * Construct a new instance of {@code HttpClientErrorException} based on
     * an {@link HttpStatus}, status text, and response body content.
     *
     * @param statusCode      the status code
     * @param statusText      the status text
     * @param responseHeaders the response headers (may be {@code null})
     * @param responseBody    the response body content (may be {@code null})
     * @param responseCharset the response body charset (may be {@code null})
     * @since 3.1.2
     */
    public UserNotFoundException(HttpStatus statusCode, String statusText, HttpHeaders responseHeaders, byte[] responseBody, Charset responseCharset) {
        super(statusCode, statusText, responseHeaders, responseBody, responseCharset);
    }
}
