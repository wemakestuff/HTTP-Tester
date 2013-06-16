package com.wemakestuff.httptester.core;

import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.io.Serializable;
import java.util.List;

public class Test implements Serializable {

    private static final long serialVersionUID = -6641292855569752036L;

    private List<BasicHeader> httpHeaders;
    private List<BasicNameValuePair> queryParameters;
    private HttpHost httpHost;

    private Constants.HttpProtocol httpProtocol;
    private Constants.RequestMethod requestMethod;

    public List<BasicHeader> getHttpHeaders() {
        return httpHeaders;
    }

    public void setHttpHeaders(List<BasicHeader> httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    public List<BasicNameValuePair> getQueryParameters() {
        return queryParameters;
    }

    public void setQueryParameters(List<BasicNameValuePair> queryParameters) {
        this.queryParameters = queryParameters;
    }

    public HttpHost getHttpHost() {
        return httpHost;
    }

    public void setHttpHost(HttpHost httpHost) {
        this.httpHost = httpHost;
    }

    public Constants.HttpProtocol getHttpProtocol() {
        return httpProtocol;
    }

    public void setHttpProtocol(Constants.HttpProtocol httpProtocol) {
        this.httpProtocol = httpProtocol;
    }

    public Constants.RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(Constants.RequestMethod requestMethod) {
        this.requestMethod = requestMethod;
    }
}
