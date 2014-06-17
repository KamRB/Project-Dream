package com.hard.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hard.core.service.MessageService;

@Component
public class MessagePrinter {

    @Autowired
    private MessageService service;

    public String printMessage() {
       return (this.service.getMessage());
    }
}