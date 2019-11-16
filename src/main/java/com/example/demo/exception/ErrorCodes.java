package com.example.demo.exception;

public enum ErrorCodes
{

    REQUEST_IS_NOT_VALID;

    public enum ContextKeys
    {
        TOPIC_DESCRIPTION_MUST_NOT_BE_NULL,
        TOPIC_NAME_MUST_NOT_BE_NULL;
    }

}
