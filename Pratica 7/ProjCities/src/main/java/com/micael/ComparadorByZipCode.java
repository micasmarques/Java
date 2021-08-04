package com.micael;

import java.util.Comparator;

public class ComparadorByZipCode implements Comparator<City> {

    @Override
    public int compare(City o1, City o2) {
        return o1.getZipCode().compareTo(o2.getZipCode());
    }
}
