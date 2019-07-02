package com.thy.mercury.object.comparator.model;

public enum ComparableFieldType {
    BOOLEAN(""), INTEGER("int"), DOUBLE(""), LONG(""), COMPLEX(""), STRING(""), LIST_SIZE(""), LIST(""), MAP(""), MAP_SIZE("");
    private String externalFieldName;
    
    ComparableFieldType(String name){
        this.externalFieldName = name;
    }
    
    public static ComparableFieldType getFromName(String name){
        for (ComparableFieldType type : ComparableFieldType.values())
        {
            if(type.name().equalsIgnoreCase(name)){
                return type;
            }else if(type.externalFieldName.equals(name)){
                return type;
            }
        }
        return null;
    }
}
