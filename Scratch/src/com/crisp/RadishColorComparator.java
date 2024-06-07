package com.crisp;

import java.util.Comparator;

public class RadishColorComparator implements Comparator<Radish> {


    /*
    * String has natural order
    * */
    @Override
    public int compare(Radish radish1, Radish radish2) {
        return radish1.getColor().compareTo(radish2.getColor()); //delegate to that color compareTo method
    }
}
