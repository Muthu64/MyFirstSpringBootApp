package com.example.demo.exception;

import java.util.ArrayList;

public class TopicExceptionBuilder
{
    private TopicException topicException;

    public TopicExceptionBuilder()
    {
        topicException = new TopicException( new ArrayList<>(), false, null );
    }

    public TopicExceptionBuilder newBuilder( ErrorCodes errorCode )
    {
        topicException.setErrorCode( errorCode );
        return this;
    }

    public TopicException build()
    {
        topicException = new TopicException( this.topicException.getErrorList(), this.topicException.isErrorFound(), this.topicException.getErrorCode() );
        return topicException;
    }

    public TopicExceptionBuilder add( ErrorCodes.ContextKeys errorCode )
    {
        this.topicException.add( errorCode );
        return this;
    }


    public TopicExceptionBuilder setErrorFound( boolean errorFound )
    {
        this.topicException.setErrorFound( errorFound );
        return this;
    }

    public void buildAndthrowIfErrorFound() throws TopicException
    {
        topicException = new TopicException( this.topicException.getErrorList(), this.topicException.isErrorFound(), this.topicException.getErrorCode() );

        if (topicException.isErrorFound()) {
            throw topicException;
        }
    }
}
