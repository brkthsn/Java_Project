package com.thy.mercury.object.comparator;

import com.thy.mercury.object.comparator.model.ChangeReport;
import com.thy.mercury.object.comparator.model.ComparableNodeElement;

public class ChangeReportDisplay extends ChangeReport
{

    public ChangeReportDisplay(ChangeReport changeReport)
    {
        setFieldName(changeReport.getFieldName());
        setFieldType(changeReport.getFieldType());
        setChangeReportType(changeReport.getChangeReportType());
        setOldValue(getOldValue(changeReport));
        setNewValue(getNewValue(changeReport));
    }

    
    public ComparableNodeElement getOldValue(ChangeReport changeReport)
    {
        if(changeReport.getOldValue() != null){
            ComparableNodeElement firstDepthParent = changeReport.getOldValue().getParent();
            if (firstDepthParent != null)
            {
                if(firstDepthParent != null && firstDepthParent.getParent() != null){
                    ComparableNodeElement secondDepthParent = firstDepthParent.getParent();
                    if(secondDepthParent.getParent() != null){
                        ComparableNodeElement thirdDepthParent = secondDepthParent.getParent();
                        if(thirdDepthParent.getParent() != null){
                            thirdDepthParent.setParent(null);
                        }
                    }
                }
            }
        }
        return changeReport.getOldValue();
    }

    
    public ComparableNodeElement getNewValue(ChangeReport changeReport)
    {
        if(changeReport.getNewValue() != null){
            ComparableNodeElement firstDepthParent = changeReport.getNewValue().getParent();
            if (firstDepthParent != null)
            {
                if(firstDepthParent != null && firstDepthParent.getParent() != null){
                    ComparableNodeElement secondDepthParent = firstDepthParent.getParent();
                    if(secondDepthParent.getParent() != null){
                        ComparableNodeElement thirdDepthParent = secondDepthParent.getParent();
                        if(thirdDepthParent.getParent() != null){
                            thirdDepthParent.setParent(null);
                        }
                    }
                }
            }
        }
        return changeReport.getNewValue();
    }

    @Override
    public String toString()
    {
        return String.format("ChangeReportDisplay [getFieldName()=%s, getOldValue()=%s, getNewValue()=%s, getFieldType()=%s, getChangeReportType()=%s, toString()=%s, getClass()=%s, hashCode()=%s]", getFieldName(), getOldValue(), getNewValue(), getFieldType(), getChangeReportType(), super.toString(), getClass(), hashCode());
    }

        
}
