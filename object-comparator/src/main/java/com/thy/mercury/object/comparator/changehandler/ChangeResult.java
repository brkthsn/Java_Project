package com.thy.mercury.object.comparator.changehandler;

public class ChangeResult<T>
{
    private T changeResults;
    
    public ChangeResult(T changeResults){
        this.changeResults = changeResults;
    }

    public T getChangeResults()
    {
        return changeResults;
    }

    public void setChangeResults(T changeResults)
    {
        this.changeResults = changeResults;
    }
}
