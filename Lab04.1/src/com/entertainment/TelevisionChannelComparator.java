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

public class TelevisionChannelComparator implements Comparator<Television> {

    @Override
    public int compare(Television television, Television television1) {
        return Integer.compare(television.getCurrentChannel(), television1.getCurrentChannel());
    }
}