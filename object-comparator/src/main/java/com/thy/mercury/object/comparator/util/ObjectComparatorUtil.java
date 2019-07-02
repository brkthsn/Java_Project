package com.thy.mercury.object.comparator.util;

import java.util.Collection;
import java.util.Map;
import com.thy.mercury.object.comparator.model.ChangeReport;
import com.thy.mercury.object.comparator.model.ChangeReportType;
import com.thy.mercury.object.comparator.model.ComparableFieldDefinition;
import com.thy.mercury.object.comparator.model.ComparableNodeElement;
import com.thy.mercury.object.comparator.model.ComparableObject;


public class ObjectComparatorUtil
{
    public static ChangeReport getReportForPrimitiveType(ComparableFieldDefinition root, ComparableNodeElement oldObj, ComparableNodeElement newObj)
    {
        ChangeReport report = null;
        if ( !(oldObj.getObj() == null && newObj.getObj() == null) && !oldObj.getObj().equals(newObj.getObj()))
        {
            report = buildReportForPrimitiveType(oldObj, newObj, root.getFieldName());
        }
        return report;
    }

    public static ChangeReport getReportForCollectionSize(Collection oldObj, Collection newObj, String fieldName)
    {
        ChangeReport changeReport = new ChangeReport();
        changeReport.setFieldName(fieldName);
        changeReport.setOldValue(new ComparableNodeElement(oldObj.size(), new ComparableNodeElement(new ComparableObject(oldObj))));
        changeReport.setNewValue(new ComparableNodeElement(newObj.size(), new ComparableNodeElement(new ComparableObject(newObj))));
        changeReport.setChangeReportType(ChangeReportType.COLLECTION_SIZE_CHANGED);
        return changeReport;
    }
    
    public static ChangeReport getReportForMapSize(Map oldObj, Map newObj, String fieldName)
    {
        ChangeReport changeReport = new ChangeReport();
        changeReport.setFieldName(fieldName);
        changeReport.setOldValue(new ComparableNodeElement(oldObj.size(), new ComparableNodeElement(new ComparableObject(oldObj))));
        changeReport.setNewValue(new ComparableNodeElement(newObj.size(), new ComparableNodeElement(new ComparableObject(newObj))));
        changeReport.setChangeReportType(ChangeReportType.MAP_SIZE_CHANGED);
        return changeReport;
    }
    
    public static ChangeReport getReportForMissingType(ComparableNodeElement oldObj, ComparableNodeElement newObj, String fieldName)
    {
        ChangeReport changeReport = new ChangeReport();
        changeReport.setFieldName(fieldName);
        changeReport.setOldValue(oldObj);
        changeReport.setNewValue(newObj);
        if (newObj == null)
        {
            changeReport.setChangeReportType(ChangeReportType.MISSING_ON_NEW);
        }
        else
        {
            changeReport.setChangeReportType(ChangeReportType.MISSING_IN_OLD);
        }
        return changeReport;
    }

    public static boolean checkObjectsChangeStatus(Object obj1, Object obj2)
    {
        if (obj1 == null)
        {
            if (obj2 == null)
            {
                //not need to compare
                return false;
            }
            else
            {
                //obj1 null obj2 not null
                return true;
            }
        }
        else if (obj2 == null)
        {
            //obj1 not null, obj2 null
            return false;
        }
        //two of objects is not null
        return true;
    }

    public static  ChangeReport buildReportForPrimitiveType(ComparableNodeElement oldFieldValue, ComparableNodeElement newFieldValue, String fieldName)
    {
        ChangeReport changeReport = new ChangeReport();
        changeReport.setFieldName(fieldName);
        changeReport.setOldValue(oldFieldValue);
        changeReport.setNewValue(newFieldValue);
        changeReport.setChangeReportType(ChangeReportType.PRIMITIVE_FIELD_CHANGE);
        return changeReport;
    }
}
