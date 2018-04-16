package com.kozlowst.microcache;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MetaDataUtils {

    public static <K, V> List<V> getParamsAsList(List<MetaData> metaData, K k) {
        return metaData.stream()
                .map((Function<MetaData, List>) MetaData::getData)
                .flatMap(Collection::stream)
                .filter(x -> ((Pair<K,V>)x).getKey().equals(k))
                .map(y -> ((Pair<K,V>)y).getValue())
                .collect(Collectors.toList());
    }

}
