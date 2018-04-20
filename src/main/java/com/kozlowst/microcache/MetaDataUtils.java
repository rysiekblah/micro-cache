package com.kozlowst.microcache;

import com.kozlowst.microcache.tuple.Tuples;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MetaDataUtils {

    @SuppressWarnings("unchecked")
    public static <K, V> List<V> getParamsAsList(List<MetaData> metaData, K k) {
        return metaData.stream()
                .map((Function<MetaData, List>) MetaData::getData)
                .flatMap(Collection::stream)
                .filter(x -> ((Tuples.Tuple2<K,V>)x)._1.equals(k))
                .map(y -> ((Tuples.Tuple2<K,V>)y)._2)
                .collect(Collectors.toList());
    }

}
