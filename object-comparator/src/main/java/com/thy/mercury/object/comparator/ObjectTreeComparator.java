package com.thy.mercury.object.comparator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.thy.mercury.object.comparator.model.ChangeReport;
import com.thy.mercury.object.comparator.model.ComparableFieldDefinition;
import com.thy.mercury.object.comparator.model.ComparableFieldType;
import com.thy.mercury.object.comparator.model.ComparableNodeElement;
import com.thy.mercury.object.comparator.model.ComparableObject;
import com.thy.mercury.object.comparator.model.ComparatorConfig;
import com.thy.mercury.object.comparator.model.TreeBasedComparatorConfig;
import com.thy.mercury.object.comparator.util.ObjectComparatorUtil;

public class ObjectTreeComparator implements ObjectComparator
{
    private ComparatorConfig config;

    public ObjectTreeComparator(ComparatorConfig config)
    {
        this.config = config;
    }

    public List<ChangeReport> compare(ComparableObject oldComparable, ComparableObject newComparable)
    {
        TreeBasedComparatorConfig treeBasedComparatorConfig = (TreeBasedComparatorConfig) config;
        List<ChangeReport> changeReportList = new ArrayList<ChangeReport>();
        try
        {
            if (oldComparable == null || oldComparable.getObj() == null)
            {
                generateReportForNullableOld(treeBasedComparatorConfig.getRoot(), new ComparableNodeElement(oldComparable), new ComparableNodeElement(newComparable), changeReportList);
            }
            else
            {
                buildChangeDetectorTree(treeBasedComparatorConfig.getRoot(), new ComparableNodeElement(oldComparable), new ComparableNodeElement(newComparable), changeReportList);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return changeReportList;
    }

    private void generateReportForNullableOld(ComparableFieldDefinition root, ComparableNodeElement oldObj, ComparableNodeElement newObj, List<ChangeReport> changeReport) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException
    {
        ChangeReport report = null;
        if (root.isGenerateReportOnNullableOld())
        {
            report = ObjectComparatorUtil.getReportForMissingType(oldObj, newObj, root.getFieldName());
            if (report != null)
            {
                changeReport.add(report);
            }
        }
        else
        {
            for (ComparableFieldDefinition child : root.getChildiren())
            {
                if (root.getFieldType().equals(ComparableFieldType.LIST))
                {
                    Collection newFieldValueList = (Collection) newObj.getObj();
                    for (Object newElement : newFieldValueList)
                    {
                        for (ComparableFieldDefinition children : root.getChildiren())
                        {
                            generateReportForNullableOld(children, new ComparableNodeElement(null, oldObj), new ComparableNodeElement(newElement, newObj), changeReport);
                        }
                    }
                }else {
                    Field newField = newObj.getObj().getClass().getDeclaredField(child.getFieldName());
                    newField.setAccessible(true);
                    Object newFieldValue = newField.get(newObj.getObj());
                    generateReportForNullableOld(child, null, new ComparableNodeElement(newFieldValue, newObj), changeReport); 
                }
            }
        }
    }

    private ChangeReport buildChangeDetectorTree(ComparableFieldDefinition root, ComparableNodeElement oldObj, ComparableNodeElement newObj, List<ChangeReport> changeReport) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
    {
        ChangeReport report = null;
        if (root.getFieldType() != null)
        {
            if (!root.getFieldType().equals(ComparableFieldType.COMPLEX) && !root.getFieldType().equals(ComparableFieldType.LIST))
            {
                report = ObjectComparatorUtil.getReportForPrimitiveType(root, oldObj, newObj);
                if (report != null)
                {
                    changeReport.add(report);
                }
            }
            else if (root.getFieldType().equals(ComparableFieldType.LIST) || root.getFieldType().equals(ComparableFieldType.LIST_SIZE))
            {
                if (oldObj == null && newObj == null)
                {
                }
                else if ((oldObj == null && newObj != null) || oldObj != null && newObj == null)
                {
                    report = ObjectComparatorUtil.getReportForMissingType(oldObj, newObj, root.getFieldName());
                }
                else
                {
                    Collection oldFieldValueList = (Collection) oldObj.getObj();
                    Collection newFieldValueList = (Collection) newObj.getObj();
                    if (!(oldFieldValueList == null && newFieldValueList == null))
                    {
                        if (oldFieldValueList.size() != newFieldValueList.size())
                        {
                            changeReport.add(ObjectComparatorUtil.getReportForCollectionSize(oldFieldValueList, newFieldValueList, root.getFieldName()));
                        }
                        List<Object> removedElements = new ArrayList<Object>();
                        List<Object> addedElements = new ArrayList<Object>();
                        List<Object> commonElementsInOld = new ArrayList<Object>();
                        List<Object> commonElementsInNew = new ArrayList<Object>();
                        for (Object oldElement : oldFieldValueList)
                        {
                            for (Object newElement : newFieldValueList)
                            {
                                if (oldElement.equals(newElement))
                                {
                                    commonElementsInOld.add(oldElement);
                                    commonElementsInNew.add(newElement);
                                    for (ComparableFieldDefinition child : root.getChildiren())
                                    {
                                        report = buildChangeDetectorTree(child, new ComparableNodeElement(oldElement, oldObj), new ComparableNodeElement(newElement, newObj), changeReport);
                                    }
                                }
                            }
                        }
                        removedElements.addAll(oldFieldValueList);
                        removedElements.removeAll(commonElementsInOld);
                        for (Object removedOldField : removedElements)
                        {
                            changeReport.add(ObjectComparatorUtil.getReportForMissingType(new ComparableNodeElement(removedOldField, oldObj), null, root.getFieldName()));
                        }
                        addedElements.addAll(newFieldValueList);
                        addedElements.removeAll(commonElementsInNew);
                        for (Object addedNewField : addedElements)
                        {
                            changeReport.add(ObjectComparatorUtil.getReportForMissingType(null, new ComparableNodeElement(addedNewField, newObj), root.getFieldName()));
                        }
                    }
                }
            }
            else if (root.getFieldType().equals(ComparableFieldType.MAP))
            {
                if (oldObj == null && newObj == null)
                {
                }
                else if ((oldObj == null && newObj != null) || oldObj != null && newObj == null)
                {
                    report = ObjectComparatorUtil.getReportForMissingType(oldObj, newObj, root.getFieldName());
                }
                else
                {
                    Map oldFieldValueList = (Map) oldObj.getObj();
                    Map newFieldValueList = (Map) newObj.getObj();
                    report = buildChangeDetectorTree(root, new ComparableNodeElement(oldFieldValueList.values(), oldObj), new ComparableNodeElement(newFieldValueList.values(), newObj), changeReport);
                }
            }
            else
            {
                for (ComparableFieldDefinition child : root.getChildiren())
                {
                    if (oldObj == null && newObj == null || (oldObj.getObj() == null && newObj.getObj() == null))
                    {
                        continue;
                    }
                    try
                    {
                        Field oldField = oldObj.getObj().getClass().getDeclaredField(child.getFieldName());
                        Field newField = newObj.getObj().getClass().getDeclaredField(child.getFieldName());
                        oldField.setAccessible(true);
                        newField.setAccessible(true);
                        Object oldFieldValue = oldField.get(oldObj.getObj());
                        Object newFieldValue = newField.get(newObj.getObj());
                        report = buildChangeDetectorTree(child, new ComparableNodeElement(oldFieldValue, oldObj), new ComparableNodeElement(newFieldValue, newObj), changeReport);
                    }
                    catch (Exception e)
                    {
                        // throw new ObjectComparisonException("Cannot compare objects  oldObj : " + oldObj +", newObj : " + newObj); 
                    }
                }
            }
        }
        return report;
    }
}
