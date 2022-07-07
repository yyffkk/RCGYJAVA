package com.api.util.createCode;

abstract class SerialNumber {
    public synchronized String getSerialNumber() {
        return process();
    }
    protected abstract String process();
}
