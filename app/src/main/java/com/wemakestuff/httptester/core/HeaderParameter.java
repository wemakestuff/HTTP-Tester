package com.wemakestuff.httptester.core;

public class HeaderParameter extends Item {
    public HeaderParameter(String name, String value) {
        super(name, value);
    }

    public String toString() {
        return name + " : " + value;
    }
}
