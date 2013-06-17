package com.wemakestuff.httptester.core;

import java.io.Serializable;

public class RequestHistory implements Serializable {

    private static final long serialVersionUID = -6641292855569752036L;

    private String url;
    private String lastUsedDate;
    private Request request;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLastUsedDate() {
        return lastUsedDate;
    }

    public void setLastUsedDate(String lastUsedDate) {
        this.lastUsedDate = lastUsedDate;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
