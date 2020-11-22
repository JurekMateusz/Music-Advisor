package com.example.musicadvisor.exceptions;

public class NotSupportedFileFormatException extends RuntimeException {
    public NotSupportedFileFormatException(String msg) {
        super(msg);
    }
}
