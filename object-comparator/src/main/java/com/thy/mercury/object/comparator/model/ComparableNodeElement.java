package com.thy.mercury.object.comparator.model;

public class ComparableNodeElement extends ComparableObject
{
    private ComparableNodeElement parent;

    public ComparableNodeElement()
    {
    }

    public ComparableNodeElement(ComparableObject obj)
    {
       super(obj.getObj());
    }

    public ComparableNodeElement(Object obj, ComparableNodeElement parent)
    {
        super(obj);
        this.parent = parent;
    }

    public ComparableNodeElement getParent()
    {
        return parent;
    }

    public void setParent(ComparableNodeElement parent)
    {
        this.parent = parent;
    }

    @Override
    public String toString()
    {
        return "ComparableObject [\n obj=" + getObj() + ",\n parent=" + parent + "]";
    }
}
