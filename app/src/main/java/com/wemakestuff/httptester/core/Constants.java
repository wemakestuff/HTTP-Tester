package com.wemakestuff.httptester.core;

import org.apache.http.HttpStatus;

public class Constants {
    public static final String REQUEST = "request";

    //TODO: Finish flushing out these default values.
    public enum HttpProtocol {
        HTTP("HTTP", "http://"),
        HTTPS("HTTPS", "https://");
        private String name;
        private String value;

        private HttpProtocol(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public static HttpProtocol findByName(String name) {
            return ValueOf.valueOf(HttpProtocol.class, "name", name);
        }

        public static HttpProtocol findByValue(String value) {
            return ValueOf.valueOf(HttpProtocol.class, "value", value);
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }

    public enum RequestMethod {
        GET("GET", "GET"),
        POST("POST", "POST"),
        PUT("PUT", "PUT"),
        DELETE("DELETE", "DELETE"),
        HEAD("HEAD", "HEAD"),
        OPTIONS("OPTIONS", "OPTIONS"),
        PATCH("PATCH", "PATCH");
        private String name;
        private String value;

        private RequestMethod(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public static RequestMethod findByName(String name) {
            return ValueOf.valueOf(RequestMethod.class, "name", name);
        }

        public static RequestMethod findByValue(String value) {
            return ValueOf.valueOf(RequestMethod.class, "value", value);
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }

    /*
     * See here: http://developer.android.com/reference/org/apache/http/HttpStatus.html for codes.
     */
    //TODO: Finish entering the codes.
    public enum HttpStatusCode {
        ACCEPTED("Accepted", HttpStatus.SC_ACCEPTED),
        BAD_GATEWAY("Bad Gateway", HttpStatus.SC_BAD_GATEWAY),
        BAD_REQUEST("Bad Request", HttpStatus.SC_BAD_REQUEST),
        CONFLICT("Conflict", HttpStatus.SC_CONFLICT),
        CONTINUE("Continue", HttpStatus.SC_CONTINUE),
        CREATED("Created", HttpStatus.SC_CREATED),
        EXPECTATION_FAILED("Expectation Failed", HttpStatus.SC_EXPECTATION_FAILED),
        FAILED_DEPENDENCY("Failed Dependency", HttpStatus.SC_FAILED_DEPENDENCY),
        FORBIDDEN("Forbidden", HttpStatus.SC_FORBIDDEN),
        GATEWAY_TIMEOUT("Gateway Timeout", HttpStatus.SC_GATEWAY_TIMEOUT),
        GONE("Gone", HttpStatus.SC_GONE);
        private String name;
        private String value;

        private HttpStatusCode(String name, int value) {
            this.name = name;
            this.value = String.valueOf(value);
        }

        public static HttpStatusCode findByName(String name) {
            return ValueOf.valueOf(HttpStatusCode.class, "name", name);
        }

        public static HttpStatusCode findByValue(int value) {
            return findByValue(String.valueOf(value));
        }

        public static HttpStatusCode findByValue(String value) {
            return ValueOf.valueOf(HttpStatusCode.class, "value", value);
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }

    //TODO: Finish flushing out these  values. See http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.2
    public enum HttpHeader {
        ACCEPT("Accept", "Accept"),
        ACCEPT_CHARSET("Accept-Charset", "Accept-Charset"),
        ACCEPT_ENCODING("Accept-Encoding", "Accept-Encoding"),
        ACCEPT_LANGUAGE("Accept-Language", "Accept-Language"),
        ACCEPT_RANGES("Accept Ranges", "Accept-Ranges"),
        AGE("Age", "Age"),
        ALLOW("Allow", "Allow"),
        AUTHORIZATION("Authorization", "Authorization"),
        CACHE_CONTROL("Cache-Control", "Cache-Control"),
        CONNECTION("Connection", "Connection"),
        CONTENT_ENCODING("Content-Encoding", "Content-Encoding"),
        CONTENT_LANGUAGE("Content-Language", "Content-Language"),
        CONTENT_LENGTH("Content-Length", "Content-Length"),
        CONTENT_LOCATION("Content-Location", "Content-Location"),
        CONTENT_MD5("Content-MD5", "Content-MD5"),
        CONTENT_RANGE("Content-Range", "Content-Range"),
        CONTENT_TYPE("Content-Type", "Content-Type"),
        DATE("Date", "Date"),
        ETAG("ETag", "ETag"),
        EXPECT("Expect", "Expect"),
        EXPIRES("Expires", "Expires"),
        FROM("From", "From"),
        HOST("Host", "Host"),
        IF_MATCH("If-Match", "If-Match"),
        IF_MODIFIED_SINCE("If-Modified-Since", "If-Modified-Since"),
        IF_NONE_MATCH("If-None-Match", "If-None-Match"),
        IF_RANGE("If-Range", "If-Range"),
        IF_UNMODIFIED_SINCE("If-Unmodified-Since", "If-Unmodified-Since"),
        LAST_MODIFIED("Last-Modified", "Last-Modified"),
        LOCATION("Location", "Location"),
        MAX_FORWARDS("Max-Forwards", "Max-Forwards"),
        PRAGMA("Pragma", "Pragma"),
        PROXY_AUTHENTICATE("Proxy-Authenticate", "Proxy-Authenticate");
        private String name;
        private String value;

        private HttpHeader(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public static HttpHeader findByName(String name) {
            return ValueOf.valueOf(HttpHeader.class, "name", name);
        }

        public static HttpHeader findByValue(String value) {
            return ValueOf.valueOf(HttpHeader.class, "value", value);
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }

    //TODO: Add in media types from http://jackson.codehaus.org/javadoc/jax-rs/1.0/javax/ws/rs/core/MediaType.html
}
