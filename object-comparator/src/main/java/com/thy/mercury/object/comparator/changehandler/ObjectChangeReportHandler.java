package com.thy.mercury.object.comparator.changehandler;

public interface ObjectChangeReportHandler<T>
{
    ChangeResult<T> generateChangeReportResult(ChangeParameters parameters) throws ChangeReportHandlerException;
}
