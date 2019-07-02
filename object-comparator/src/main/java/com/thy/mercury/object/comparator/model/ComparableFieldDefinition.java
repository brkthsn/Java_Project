package com.thy.mercury.object.comparator.model;

import java.util.ArrayList;
import java.util.List;

public class ComparableFieldDefinition
{
    private ComparableFieldDefinition parent;
    private String fieldName;
    private ComparableFieldType fieldType;
    private List<ComparableFieldDefinition> childiren = new ArrayList();
    private boolean generateReportOnNullableOld = false;
    private boolean hasChildReportOnNullableOld;

    public ComparableFieldDefinition()
    {
    }

    public boolean isHasChildReportOnNullableOld()
    {
        return hasChildReportOnNullableOld;
    }

    public void setHasChildReportOnNullableOld(boolean hasChildReportOnNullableOld)
    {
        this.hasChildReportOnNullableOld = hasChildReportOnNullableOld;
    }

    public ComparableFieldDefinition(String fieldName, ComparableFieldType fieldType, ComparableFieldDefinition parent)
    {
        this.fieldName = fieldName;
        this.fieldType = fieldType;
    }

    public ComparableFieldDefinition(String fieldName, ComparableFieldType fieldType, ComparableFieldDefinition parent, boolean generateReportOnNullableOld)
    {
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.generateReportOnNullableOld = generateReportOnNullableOld;
    }

    public String getFieldName()
    {
        return fieldName;
    }

    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
    }

    public ComparableFieldType getFieldType()
    {
        return fieldType;
    }

    public void setFieldType(ComparableFieldType fieldType)
    {
        this.fieldType = fieldType;
    }

    public List<ComparableFieldDefinition> getChildiren()
    {
        return childiren;
    }

    public void setChildiren(List<ComparableFieldDefinition> childiren)
    {
        this.childiren = childiren;
    }

    public void addChild(ComparableFieldDefinition child)
    {
        getChildiren().add(child);
    }

    public ComparableFieldDefinition getParent()
    {
        return parent;
    }

    public void setParent(ComparableFieldDefinition parent)
    {
        this.parent = parent;
    }

    public boolean isGenerateReportOnNullableOld()
    {
        return generateReportOnNullableOld;
    }

    public void setGenerateReportOnNullableOld(boolean generateReportOnNullableOld)
    {
        this.generateReportOnNullableOld = generateReportOnNullableOld;
    }

    @Override
    public String toString()
    {
        return "ComparableField [parent=" + parent + ", fieldName=" + fieldName + ", fieldType=" + fieldType + ", childiren=" + childiren + "]";
    }
}
