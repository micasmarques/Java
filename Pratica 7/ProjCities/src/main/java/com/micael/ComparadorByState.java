package com.micael;

import java.util.Comparator;

public class ComparadorByState implements Comparator<City> {

    @Override
    public int compare(City o1, City o2) {
        return o1.getSigla().compareTo(o2.getSigla());
    }
}
