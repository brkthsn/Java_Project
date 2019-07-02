package com.thy.mercury.object.comparator.model;

public class ChangeReport
{
    private String fieldName;
    private ComparableNodeElement oldValue;
    private ComparableNodeElement newValue;
    private ComparableFieldType fieldType;
    private ChangeReportType changeReportType;

    public String getFieldName()
    {
        return fieldName;
    }

    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
    }

    public ComparableNodeElement getOldValue()
    {
        return oldValue;
    }

    public void setOldValue(ComparableNodeElement oldValue)
    {
        this.oldValue = oldValue;
    }

    public ComparableNodeElement getNewValue()
    {
        return newValue;
    }

    public void setNewValue(ComparableNodeElement newValue)
    {
        this.newValue = newValue;
    }

    public ComparableFieldType getFieldType()
    {
        return fieldType;
    }

    public void setFieldType(ComparableFieldType fieldType)
    {
        this.fieldType = fieldType;
    }

    public ChangeReportType getChangeReportType()
    {
        return changeReportType;
    }

    public void setChangeReportType(ChangeReportType changeReportType)
    {
        this.changeReportType = changeReportType;
    }

    @Override
    public String toString()
    {
        return "ChangeReport [\n fieldName=" + fieldName + ",\n oldValue=" + oldValue + ",\n newValue=" + newValue + ",\n fieldType=" + fieldType + ",\n changeReportType=" + changeReportType + "]";
    }
}
