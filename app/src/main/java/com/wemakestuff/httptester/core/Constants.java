package com.wemakestuff.httptester.core;

import org.apache.http.HttpStatus;

public class Constants {
    //TODO: Finish flushing out these default values.
    public enum HttpProtocol {
        HTTP("HTTP", "http://"),
        HTTPS("HTTPS", "https://");
        private String label;
        private String value;

        private HttpProtocol(String label, String value) {
            this.label = label;
            this.value = value;
        }

        public static HttpProtocol valueOfLabel(String label) {
            return ValueOf.valueOf(HttpProtocol.class, "label", label);
        }

        public static HttpProtocol valueOfValue(String value) {
            return ValueOf.valueOf(HttpProtocol.class, "value", value);
        }

        public String getLabel() {
            return label;
        }

        public String getValue() {
            return value;
        }
    }

    //TODO: Finish flushing out these default values.
    public enum RequestMethod {
        GET("GET", "GET"),
        POST("POST", "POST");
        private String label;
        private String value;

        private RequestMethod(String label, String value) {
            this.label = label;
            this.value = value;
        }

        public static RequestMethod valueOfLabel(String label) {
            return ValueOf.valueOf(RequestMethod.class, "label", label);
        }

        public static RequestMethod valueOfValue(String value) {
            return ValueOf.valueOf(RequestMethod.class, "value", value);
        }

        public String getLabel() {
            return label;
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
        private String label;
        private int value;

        private HttpStatusCode(String label, int value) {
            this.label = label;
            this.value = value;
        }

        public static HttpStatusCode valueOfLabel(String label) {
            return ValueOf.valueOf(HttpStatusCode.class, "label", label);
        }

        public static HttpStatusCode valueOfValue(int value) {
            return ValueOf.valueOf(HttpStatusCode.class, "value", value);
        }

        public String getLabel() {
            return label;
        }

        public int getValue() {
            return value;
        }
    }

    //TODO: Finish flushing out these default values.
    public enum HttpHeader {
        KEEP_ALIVE("Keep-Alive", "Keep-Alive"),
        CONTENT_ENCODING("Content-Encoding", "Content-Encoding"),
        CONTENT_LENGTH("Content-Length", "Content-Length"),
        CONTENT_TYPE("Content-Type", "Content-Type");
        private String label;
        private String value;

        private HttpHeader(String label, String value) {
            this.label = label;
            this.value = value;
        }

        public static HttpHeader valueOfLabel(String label) {
            return ValueOf.valueOf(HttpHeader.class, "label", label);
        }

        public static HttpHeader valueOfValue(String value) {
            return ValueOf.valueOf(HttpHeader.class, "value", value);
        }

        public String getLabel() {
            return label;
        }

        public String getValue() {
            return value;
        }
        }
}
