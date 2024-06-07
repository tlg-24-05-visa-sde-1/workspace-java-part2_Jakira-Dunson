package com.crisp;

import java.util.ArrayList;
import java.util.List;

public class RadishSortTest {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<Radish>();

        radishes.add(new Radish("Red",1.5,2.5,5));
        radishes.add(new Radish("Black",1.0,0.0,0));
        radishes.add(new Radish("Red",2.7,5.5,0));
        radishes.add(new Radish("Pink",0.9,0,6));

        System.out.println("Original List");
        dump(radishes);

        System.out.println();

        System.out.println("Sort by natural order");
        radishes.sort(null); //passing null means natural order
        dump(radishes);

        System.out.println();
        /*
        * radishes is used instead of Radishes because radishes represents an instance (specifically, a list)
        * of the Radishes class (or more likely a List<Radish> if we are dealing with a collection of Radish objects).
        * radishes is a variable name that likely holds an instance of a list of Radish objects.
        * Radishes would refer to the class definition, which is not used directly for sorting.
        */

        System.out.println("Sort by Radish Color by Comparator Class");
        radishes.sort(new RadishColorComparator());
        dump(radishes);

        System.out.println();
        System.out.println("Sort by Radish Guys on Top by Comparator Class");
        radishes.sort(new RadishGuysOnTopComparator());
        dump(radishes);

    }
    private static void dump(List<Radish> radishes) {
        for (Radish radish : radishes){
            System.out.println(radish);

        }
    }


}
