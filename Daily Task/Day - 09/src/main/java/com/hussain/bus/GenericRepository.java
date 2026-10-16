package com.hussain.bus;

import java.util.ArrayList;
import java.util.List;

public class GenericRepository<T> {

    private final List<T> data = new ArrayList<>();

    public void save(T value) {
        data.add(value);
    }

    public List<T> findAll() {
        return new ArrayList<>(data);
    }

    public int size() {
        return data.size();
    }
}