package com.agroambles.olavera.flatsmanagement.views;

/**
 * @author Olavera
 */
public enum Sections {
    BUILDING_LIST_FRAGMENT(0),
    FLAT_LIST_FRAGMENT(101),
    UNKNOWN(999);

    private int mPosition;

    private Sections(int position){
        this.mPosition = position;
    }

    public int getPosition(){
        return mPosition;
    }

    public static Sections parseSection(int position){
        Sections ret = UNKNOWN;
        if(BUILDING_LIST_FRAGMENT.getPosition() == position){
            ret = BUILDING_LIST_FRAGMENT;
        } else if (FLAT_LIST_FRAGMENT.getPosition() == position) {
            ret = FLAT_LIST_FRAGMENT;
        }
        return ret;
    }
}
