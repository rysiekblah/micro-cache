package com.kozlowst.microcache;

import java.util.ArrayList;
import java.util.List;

public class MetaData<T extends Pair> {

    private List<T> data = new ArrayList<>();

    protected void add(Object k, Object v) {
        //noinspection unchecked
        add((T) new Pair(k, v));
    }

    protected void add(T p) {
        data.add(p);
    }

    public List<T> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "MetaData{" + data + '}';
    }

}
