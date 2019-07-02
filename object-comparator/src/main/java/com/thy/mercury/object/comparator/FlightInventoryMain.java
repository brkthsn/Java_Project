package com.thy.mercury.object.comparator;

import java.util.ArrayList;
import java.util.List;
import com.thy.mercury.inventory.all.model.FlightInventory;
import com.thy.mercury.object.comparator.model.ChangeReport;
import com.thy.mercury.object.comparator.model.ComparableFieldDefinition;
import com.thy.mercury.object.comparator.model.ComparableFieldType;
import com.thy.mercury.object.comparator.model.ComparatorConfig;
import com.thy.mercury.object.comparator.model.TreeBasedComparatorConfig;

public class FlightInventoryMain
{
    public static void main(String[] args)
    {
        ComparatorConfig config = getInventoryComparatorConfig();
        ObjectComparator comparator = new ObjectTreeComparator(config);
        FlightInventory oldObj = new FlightInventory();
        FlightInventory newObj = new FlightInventory();
        InventoryChangeReporter changeReporter = new InventoryChangeReporter(comparator);
        List<ChangeReport> output = changeReporter.generateChangeReport(oldObj, newObj);
        List<ChangeReportDisplay> displayList = convertToDisplayList(output);
        //System.out.println(displayList);
    }

    private static List<ChangeReportDisplay> convertToDisplayList(List<ChangeReport> output)
    {
        List<ChangeReportDisplay> displayList = new ArrayList<ChangeReportDisplay>();
        for (ChangeReport changeReport : output)
        {
            ChangeReportDisplay display = new ChangeReportDisplay(changeReport);
            displayList.add(display);
        }
        return displayList;
    }

    private static ComparatorConfig getInventoryComparatorConfig()
    {
        TreeBasedComparatorConfig<FlightInventory> config = new TreeBasedComparatorConfig<FlightInventory>();
        ComparableFieldDefinition root = new ComparableFieldDefinition("flightInventory", ComparableFieldType.COMPLEX, null);
        ComparableFieldDefinition flightIndicators = new ComparableFieldDefinition("flightIndicators", ComparableFieldType.COMPLEX, root);
        ComparableFieldDefinition flightNoopDueSchedule = new ComparableFieldDefinition("flightNoopDueSchedule", ComparableFieldType.BOOLEAN, flightIndicators);
        ComparableFieldDefinition dontSellSeatInd = new ComparableFieldDefinition("dontSellSeatInd", ComparableFieldType.BOOLEAN, flightIndicators);
        ComparableFieldDefinition flightIsAutoStatused = new ComparableFieldDefinition("flightIsAutoStatused", ComparableFieldType.BOOLEAN, flightIndicators);
        ComparableFieldDefinition revertToManualStatusing = new ComparableFieldDefinition("revertToManualStatusing", ComparableFieldType.BOOLEAN, flightIndicators);
        flightIndicators.getChildiren().add(flightNoopDueSchedule);
        flightIndicators.getChildiren().add(dontSellSeatInd);
        flightIndicators.getChildiren().add(flightIsAutoStatused);
        flightIndicators.getChildiren().add(revertToManualStatusing);
        root.getChildiren().add(flightIndicators);
        //TODO add size items
        //ComparableFieldDefinition numberOfLeg = new ComparableFieldDefinition("flightLeg", ComparableFieldType.LIST_SIZE, root);
        // root.getChildiren().add(numberOfLeg);
        ComparableFieldDefinition numberOfCompartments = new ComparableFieldDefinition("numberOfCompartments", ComparableFieldType.INTEGER, root);
        root.getChildiren().add(numberOfCompartments);
        ComparableFieldDefinition flightPostingIndicators = new ComparableFieldDefinition("flightPostingIndicators", ComparableFieldType.INTEGER, root);
        root.getChildiren().add(flightPostingIndicators);
        ComparableFieldDefinition flightLeg = new ComparableFieldDefinition("flightLeg", ComparableFieldType.MAP, root);
        ComparableFieldDefinition flightLegItem = new ComparableFieldDefinition("flightLegItem", ComparableFieldType.COMPLEX, root);
        flightLeg.addChild(flightLegItem);
        root.getChildiren().add(flightLeg);
        ComparableFieldDefinition origin = new ComparableFieldDefinition("origin", ComparableFieldType.STRING, flightLeg);
        ComparableFieldDefinition destination = new ComparableFieldDefinition("destination", ComparableFieldType.STRING, flightLeg);
        ComparableFieldDefinition airportCanxDueFlifo = new ComparableFieldDefinition("airportCanxDueFlifo", ComparableFieldType.BOOLEAN, flightLeg);
        ComparableFieldDefinition bidPriceON = new ComparableFieldDefinition("bidPriceON", ComparableFieldType.BOOLEAN, flightLeg);
        flightLegItem.getChildiren().add(origin);
        flightLegItem.getChildiren().add(destination);
        flightLegItem.getChildiren().add(airportCanxDueFlifo);
        flightLegItem.getChildiren().add(bidPriceON);
        ComparableFieldDefinition flightSegmentList = new ComparableFieldDefinition("flightSegment", ComparableFieldType.MAP, root);
        ComparableFieldDefinition flightSegment = new ComparableFieldDefinition("flightSegment", ComparableFieldType.COMPLEX, root);
        flightSegmentList.addChild(flightSegment);
        root.addChild(flightSegmentList);
        ComparableFieldDefinition bookingClassList = new ComparableFieldDefinition("bookingClass", ComparableFieldType.LIST, flightSegment);
        ComparableFieldDefinition bookingClass = new ComparableFieldDefinition("bookingClass", ComparableFieldType.COMPLEX, bookingClassList);
        bookingClassList.getChildiren().add(bookingClass);
        flightSegment.getChildiren().add(bookingClassList);
        ComparableFieldDefinition sequenceNumberOfOffPoint = new ComparableFieldDefinition("sequenceNumberOfOffPoint", ComparableFieldType.STRING, bookingClass);
        ComparableFieldDefinition classCode = new ComparableFieldDefinition("classCode", ComparableFieldType.STRING, bookingClass);
        ComparableFieldDefinition availibilityOfClass = new ComparableFieldDefinition("availibilityOfClass", ComparableFieldType.STRING, bookingClass);
        ComparableFieldDefinition classIndicatorsStatusing = new ComparableFieldDefinition("classIndicatorsStatusing", ComparableFieldType.COMPLEX, bookingClass);
        ComparableFieldDefinition classIndicators3 = new ComparableFieldDefinition("classIndicators3", ComparableFieldType.COMPLEX, bookingClass);
        ComparableFieldDefinition classIndicators4 = new ComparableFieldDefinition("classIndicators4", ComparableFieldType.COMPLEX, bookingClass);
        ComparableFieldDefinition effectiveDateOfProduct = new ComparableFieldDefinition("effectiveDateOfProduct", ComparableFieldType.STRING, bookingClass);
        ComparableFieldDefinition dicontinueDateOfProduct = new ComparableFieldDefinition("dicontinueDateOfProduct", ComparableFieldType.STRING, bookingClass);
        ComparableFieldDefinition legRestriction = new ComparableFieldDefinition("legRestriction", ComparableFieldType.STRING, bookingClass);
        bookingClass.addChild(sequenceNumberOfOffPoint);
        bookingClass.addChild(classCode);
        bookingClass.addChild(availibilityOfClass);
        bookingClass.addChild(classIndicatorsStatusing);
        bookingClass.addChild(classIndicators3);
        bookingClass.addChild(classIndicators4);
        bookingClass.addChild(effectiveDateOfProduct);
        bookingClass.addChild(dicontinueDateOfProduct);
        bookingClass.addChild(legRestriction);
        ComparableFieldDefinition autostatusingPostingAppliesWithoutNotificaton = new ComparableFieldDefinition("autostatusingPostingAppliesWithoutNotificaton", ComparableFieldType.BOOLEAN, classIndicatorsStatusing);
        classIndicatorsStatusing.addChild(autostatusingPostingAppliesWithoutNotificaton);
        ComparableFieldDefinition effectiveDateChanged = new ComparableFieldDefinition("effectiveDateChanged", ComparableFieldType.BOOLEAN, classIndicators3);
        ComparableFieldDefinition discontinueDateChanged = new ComparableFieldDefinition("discontinueDateChanged", ComparableFieldType.BOOLEAN, classIndicators3);
        classIndicators3.addChild(effectiveDateChanged);
        classIndicators3.addChild(discontinueDateChanged);
        ComparableFieldDefinition waitlistInhibitionChanged = new ComparableFieldDefinition("waitlistInhibitionChanged", ComparableFieldType.BOOLEAN, classIndicators4);
        ComparableFieldDefinition wlClearanceInhibitChanged = new ComparableFieldDefinition("wlClearanceInhibitChanged", ComparableFieldType.BOOLEAN, classIndicators4);
        classIndicators4.addChild(waitlistInhibitionChanged);
        classIndicators4.addChild(wlClearanceInhibitChanged);
        config.setRoot(root);
        return config;
    }
}
