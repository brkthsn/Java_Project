package com.thy.mercury.object.comparator.model;

public class TreeBasedComparatorConfig<T> implements ComparatorConfig<T>
{
    private ComparableFieldDefinition root;

    public ComparableFieldDefinition getRoot()
    {
        return root;
    }

    public void setRoot(ComparableFieldDefinition root)
    {
        this.root = root;
    }
}
