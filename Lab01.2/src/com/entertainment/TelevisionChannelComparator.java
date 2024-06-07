package com.entertainment;

import java.nio.channels.Channel;
import java.util.Comparator;

public class TelevisionChannelComparator implements Comparator<Television> {
    @Override
    public int compare(Television television1, Television television2) {
        return Integer.compare(television1.getCurrentChannel(),television2.getCurrentChannel());
    }
}
