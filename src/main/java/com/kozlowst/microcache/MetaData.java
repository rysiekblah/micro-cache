package com.kozlowst.microcache;

import java.util.ArrayList;
import java.util.List;

import com.kozlowst.microcache.tuple.Tuples.Tuple2;

import static com.kozlowst.microcache.tuple.Tuples.tuple;

public class MetaData {

    private List<Tuple2> data = new ArrayList<>();

    protected void add(Object k, Object v) {
        add(tuple(k, v));
    }

    protected void add(Tuple2 tuple) {
        data.add(tuple);
    }

    public List<Tuple2> getData() {
        return data;
    }

}
