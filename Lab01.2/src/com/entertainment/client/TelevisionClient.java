package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TelevisionClient {

    public static void main(String[] args) {

        // examine == and the equals() method
        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        Television tvC = new Television("Samsung", 52);
        Television tvD = new Television("LG", 12);

        System.out.println("tvA == tvB: " + (tvA == tvB));
        System.out.println("tvA.equals(tvB): " + tvA.equals(tvB));
        System.out.println();


        /*
        * Television did not have natural order Treeset would not be happy and exception is trown
        *
        *
        * */

        Set<Television> tvs = new TreeSet<>();
        tvs.add(tvA);
        tvs.add(tvB);
        tvs.add(tvC);
        tvs.add(tvD);

        System.out.println("The size of the set is: " + tvs.size());

        for (Television tv : tvs) {
            System.out.println(tv);
        }
    }
}