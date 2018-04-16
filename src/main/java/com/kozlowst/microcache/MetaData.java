package com.kozlowst.microcache;

import java.util.ArrayList;
import java.util.List;

public class MetaData {

    private List<String> data = new ArrayList<>();

    void add(String name, Object value) {
        data.add(name + ":" + value);
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "data=" + data +
                '}';
    }

}
