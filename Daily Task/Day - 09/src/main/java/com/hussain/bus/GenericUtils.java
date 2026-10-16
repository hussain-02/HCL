package com.hussain.bus;

import java.util.List;

public final class GenericUtils {

    private GenericUtils() {
    }

    public static <T> void printAll(
            List<T> values) {

        for (T value : values) {
            System.out.println(value);
        }
    }

    public static double calculate(
            List<? extends Number> values) {

        double total = 0;

        for (Number value : values) {
            total += value.doubleValue();
        }

        return total;
    }
}