package com.thy.mercury.object.comparator.model;

public class ComparableObject
{
    private Object obj;
    
    public ComparableObject(){
        
    }

    public ComparableObject(Object obj)
    {
        this.obj = obj;
    }

    public Object getObj()
    {
        return obj;
    }

    public void setObj(Object obj)
    {
        this.obj = obj;
    }
}
