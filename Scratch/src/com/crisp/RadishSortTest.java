package com.crisp;

import java.util.ArrayList;
import java.util.List;

public class RaddishSortTest {
    public static void main(String[] args) {
        List<Raddish> raddishes = new ArrayList<Raddish>();

        raddishes.add(new Raddish("Red",1.5,2.5,5));
        raddishes.add(new Raddish("Black",1.0,0.0,0));
        raddishes.add(new Raddish("Red",2.7,5.5,0));
        raddishes.add(new Raddish("Pink",0.9,0,6));

        dump(raddishes);
    }

    private static void dump(List<Raddish> raddishes) {

        
    }
}
