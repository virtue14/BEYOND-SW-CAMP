package com.ohgiraffers.section02.userexception.exception;

import jdk.jshell.spi.ExecutionControlProvider;

public class MoneyNegativeException extends Exception {
    public MoneyNegativeException(String message) {
        super(message);
    }
}
