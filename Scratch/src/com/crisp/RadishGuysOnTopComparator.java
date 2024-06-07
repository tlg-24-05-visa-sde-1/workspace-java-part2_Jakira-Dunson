package com.crisp;

import java.util.Comparator;

public class RadishGuysOnTopComparator implements Comparator<Radish> {
    @Override
    public int compare(Radish radish01, Radish radish02) {
        return Integer.compare(radish01.getGuysOnTop(), radish02.getGuysOnTop());
    }
}
