package com.thy.mercury.object.comparator.model;

import com.thy.mercury.inventory.all.model.FlightInventory;

public class InventoryComparatorConfig extends TreeBasedComparatorConfig<FlightInventory>
{
    public static final String key = "AVS_INVENTORY_COMPARATOR_CONFIG";
    private TreeBasedComparatorConfig<FlightInventory> config;

    public InventoryComparatorConfig(TreeBasedComparatorConfig config)
    {
        this.config = config;
    }

   /* public static ComparatorConfig getInventoryComparatorConfig()
    {
        TreeBasedComparatorConfig<FlightInventory> config = new TreeBasedComparatorConfig<FlightInventory>();
        ComparableFieldDefinition root = new ComparableFieldDefinition("flightInventory", ComparableFieldType.COMPLEX, null);
        ComparableFieldDefinition flightIndicators = new ComparableFieldDefinition("flightIndicators", ComparableFieldType.COMPLEX, root);
        ComparableFieldDefinition flightNoopDueFlifo = new ComparableFieldDefinition("flightNoopDueFlifo", ComparableFieldType.BOOLEAN, flightIndicators);
        flightIndicators.getChildiren().add(flightNoopDueFlifo);
        root.getChildiren().add(flightIndicators);
        ComparableFieldDefinition flightLeg = new ComparableFieldDefinition("flightLeg", ComparableFieldType.LIST, root);
        ComparableFieldDefinition flightLegItem = new ComparableFieldDefinition("flightLegItem", ComparableFieldType.COMPLEX, root);
        flightLeg.addChild(flightLegItem);
        root.getChildiren().add(flightLeg);
        ComparableFieldDefinition origin = new ComparableFieldDefinition("origin", ComparableFieldType.STRING, flightLeg);
        ComparableFieldDefinition destination = new ComparableFieldDefinition("destination", ComparableFieldType.STRING, flightLeg);
        ComparableFieldDefinition airportCanxDueFlifo = new ComparableFieldDefinition("originAirportCanxDueFlifo", ComparableFieldType.BOOLEAN, flightLeg);
        ComparableFieldDefinition destinationAirportCanxDueFlifo = new ComparableFieldDefinition("destinationAirportCanxDueFlifo", ComparableFieldType.BOOLEAN, flightLeg);
        flightLegItem.getChildiren().add(origin);
        flightLegItem.getChildiren().add(destination);
        flightLegItem.getChildiren().add(airportCanxDueFlifo);
        flightLegItem.getChildiren().add(destinationAirportCanxDueFlifo);
        ComparableFieldDefinition flightSegmentList = new ComparableFieldDefinition("flightSegment", ComparableFieldType.LIST, root);
        ComparableFieldDefinition flightSegment = new ComparableFieldDefinition("flightSegment", ComparableFieldType.COMPLEX, root);
        flightSegmentList.addChild(flightSegment);
        root.addChild(flightSegmentList);
        ComparableFieldDefinition bookingClassList = new ComparableFieldDefinition("bookingClass", ComparableFieldType.LIST, flightSegment);
        ComparableFieldDefinition bookingClass = new ComparableFieldDefinition("bookingClass", ComparableFieldType.COMPLEX, bookingClassList);
        bookingClassList.getChildiren().add(bookingClass);
        flightSegment.getChildiren().add(bookingClassList);
        ComparableFieldDefinition classCode = new ComparableFieldDefinition("classCode", ComparableFieldType.STRING, bookingClass);
        ComparableFieldDefinition availibilityOfClass = new ComparableFieldDefinition("availibilityOfClass", ComparableFieldType.STRING, bookingClass);
        ComparableFieldDefinition classIndicatorsGeneral = new ComparableFieldDefinition("classIndicatorsGeneral", ComparableFieldType.COMPLEX, bookingClass);
        bookingClass.addChild(classCode);
        bookingClass.addChild(availibilityOfClass);
        bookingClass.addChild(classIndicatorsGeneral);
        ComparableFieldDefinition automaticWaitlistClearanceInhibited = new ComparableFieldDefinition("automaticWaitlistClearanceInhibited", ComparableFieldType.BOOLEAN, classIndicatorsGeneral);
        ComparableFieldDefinition waitlistingPrevented = new ComparableFieldDefinition("waitlistingPrevented", ComparableFieldType.BOOLEAN, classIndicatorsGeneral);
        classIndicatorsGeneral.addChild(automaticWaitlistClearanceInhibited);
        classIndicatorsGeneral.addChild(waitlistingPrevented);

        config.setRoot(root);
        return config;
    }
*/
    
    public static ComparatorConfig getInventoryComparatorConfig()
    {
        TreeBasedComparatorConfig<FlightInventory> config = new TreeBasedComparatorConfig<FlightInventory>();
        ComparableFieldDefinition root = new ComparableFieldDefinition("flightInventory", ComparableFieldType.COMPLEX, null);
        ComparableFieldDefinition flightIndicators = new ComparableFieldDefinition("flightIndicators", ComparableFieldType.COMPLEX, root);
        ComparableFieldDefinition flightNoopDueFlifo = new ComparableFieldDefinition("flightNoopDueFlifo", ComparableFieldType.BOOLEAN, flightIndicators);
        flightIndicators.getChildiren().add(flightNoopDueFlifo);
        root.getChildiren().add(flightIndicators);
        ComparableFieldDefinition flightLeg = new ComparableFieldDefinition("flightLeg", ComparableFieldType.LIST, root);
        ComparableFieldDefinition flightLegItem = new ComparableFieldDefinition("flightLegItem", ComparableFieldType.COMPLEX, root);
        flightLeg.addChild(flightLegItem);
        root.getChildiren().add(flightLeg);
        ComparableFieldDefinition origin = new ComparableFieldDefinition("origin", ComparableFieldType.STRING, flightLeg);
        ComparableFieldDefinition destination = new ComparableFieldDefinition("destination", ComparableFieldType.STRING, flightLeg);
        ComparableFieldDefinition airportCanxDueFlifo = new ComparableFieldDefinition("originAirportCanxDueFlifo", ComparableFieldType.BOOLEAN, flightLeg);
        ComparableFieldDefinition destinationAirportCanxDueFlifo = new ComparableFieldDefinition("destinationAirportCanxDueFlifo", ComparableFieldType.BOOLEAN, flightLeg);
        flightLegItem.getChildiren().add(origin);
        flightLegItem.getChildiren().add(destination);
        flightLegItem.getChildiren().add(airportCanxDueFlifo);
        flightLegItem.getChildiren().add(destinationAirportCanxDueFlifo);
        ComparableFieldDefinition flightSegmentList = new ComparableFieldDefinition("flightSegment", ComparableFieldType.LIST, root);
        flightSegmentList.setHasChildReportOnNullableOld(true);
        ComparableFieldDefinition flightSegment = new ComparableFieldDefinition("flightSegment", ComparableFieldType.COMPLEX, root, true);
        flightSegmentList.addChild(flightSegment);
        root.addChild(flightSegmentList);
        ComparableFieldDefinition bookingClassList = new ComparableFieldDefinition("bookingClass", ComparableFieldType.LIST, flightSegment);
        ComparableFieldDefinition bookingClass = new ComparableFieldDefinition("bookingClass", ComparableFieldType.COMPLEX, bookingClassList);
        bookingClassList.getChildiren().add(bookingClass);
        flightSegment.getChildiren().add(bookingClassList);
        ComparableFieldDefinition classCode = new ComparableFieldDefinition("classCode", ComparableFieldType.STRING, bookingClass);
        ComparableFieldDefinition availibilityOfClass = new ComparableFieldDefinition("availibilityOfClass", ComparableFieldType.STRING, bookingClass);
        ComparableFieldDefinition classIndicatorsGeneral = new ComparableFieldDefinition("classIndicatorsGeneral", ComparableFieldType.COMPLEX, bookingClass);
        bookingClass.addChild(classCode);
        bookingClass.addChild(availibilityOfClass);
        bookingClass.addChild(classIndicatorsGeneral);
        ComparableFieldDefinition automaticWaitlistClearanceInhibited = new ComparableFieldDefinition("automaticWaitlistClearanceInhibited", ComparableFieldType.BOOLEAN, classIndicatorsGeneral);
        ComparableFieldDefinition waitlistingPrevented = new ComparableFieldDefinition("waitlistingPrevented", ComparableFieldType.BOOLEAN, classIndicatorsGeneral);
        classIndicatorsGeneral.addChild(automaticWaitlistClearanceInhibited);
        classIndicatorsGeneral.addChild(waitlistingPrevented);

        config.setRoot(root);
        return config;
    }


    public TreeBasedComparatorConfig<FlightInventory> getConfig()
    {
        return config;
    }
}
