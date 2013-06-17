package com.wemakestuff.httptester.core;

public class QueryParameter extends Item {
    public QueryParameter(String name, String value) {
        super(name, value);
    }

    public String toString() {
        return name + "=" + value;
    }
}
