/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

import java.util.Comparator;

public class TelevisionBrandChannelComparator implements Comparator<Television> {

    @Override
    public int compare(Television television, Television television1) {
        int result = television.getBrand().compareTo(television1.getBrand());

        if (result == 0) {
            result = Integer.compare(television.getCurrentChannel(), television1.getCurrentChannel());
        }
        return result;
    }
}