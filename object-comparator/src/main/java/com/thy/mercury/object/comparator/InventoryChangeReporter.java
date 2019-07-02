package com.thy.mercury.object.comparator;

import java.util.ArrayList;
import java.util.List;

import com.thy.mercury.inventory.all.model.FlightInventory;
import com.thy.mercury.object.comparator.model.ChangeReport;
import com.thy.mercury.object.comparator.model.ComparableObject;
import com.thy.mercury.object.comparator.model.ComparatorConfig;

public class InventoryChangeReporter implements ChangeReporter<FlightInventory>
{
    private ObjectComparator comparator;
    
    public InventoryChangeReporter(ObjectComparator comparator){
        this.comparator = comparator;
    }
    
    public List<ChangeReport> generateChangeReport(FlightInventory oldObj, FlightInventory newObj)
    {
        List<ChangeReport> changeReport = new ArrayList<>();
        try
        {
            ComparableObject oldComparable = new ComparableObject(oldObj);
            ComparableObject newComparable = new ComparableObject(newObj);
            changeReport = comparator.compare(oldComparable, newComparable);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return changeReport;
    }
}
