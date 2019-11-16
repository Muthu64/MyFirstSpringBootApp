package com.example.demo.exception;

import java.util.List;

public class TopicException extends Exception
{
    private List<ErrorCodes.ContextKeys> errorList;
    private boolean errorFound;

    private ErrorCodes errorCode;

    public TopicException( List<ErrorCodes.ContextKeys> errorList, boolean errorFound, ErrorCodes errorCode )
    {
        this.errorList = errorList;
        this.errorFound = errorFound;
        this.errorCode = errorCode;
    }

    public void add( ErrorCodes.ContextKeys value )
    {
        this.errorList.add( value );
    }

    public List<ErrorCodes.ContextKeys> getErrorList()
    {
        return errorList;
    }

    public void setErrorList( List<ErrorCodes.ContextKeys> errorList )
    {
        this.errorList = errorList;
    }

    public ErrorCodes getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode( ErrorCodes errorCode )
    {
        this.errorCode = errorCode;
    }

    public boolean isErrorFound()
    {
        return errorFound;
    }

    public void setErrorFound( boolean errorFound )
    {
        this.errorFound = errorFound;
    }

}
