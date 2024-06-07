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

        dump(radishes);
    }
    private static void dump(List<Radish> radishes) {
        for (Radish radish : radishes){
            System.out.println(radish);

        }
    }


}
