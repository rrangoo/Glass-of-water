package com.glassofwater.gow.service.email;

public interface EmailRegister {
    void send(String to, String title, String body);
}
