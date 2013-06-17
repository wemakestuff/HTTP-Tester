package com.wemakestuff.httptester.core;

import java.io.Serializable;

public class RequestHistory implements Serializable {

    private static final long serialVersionUID = -6641292855569752036L;

    private String url;
    private String lastUsedDate;
    private Request request;

}
