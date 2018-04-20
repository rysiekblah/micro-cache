package com.kozlowst.microcache;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.kozlowst.microcache.annotations.DeltaIgnore;
import com.kozlowst.microcache.tuple.Tuples.Tuple2;

import static com.kozlowst.microcache.tuple.Tuples.tuple;

public class Cache<K, V> {

    private Map<K, V> cache;
    private Map<String, Class> model;
    private String keyFieldName;

    public Cache(Class<V> clazz, String keyFieldName) {
        model = new HashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            model.put(field.getName(), field.getType());
        }
        this.keyFieldName = keyFieldName;
        this.cache = new ConcurrentHashMap<>();
    }

    public Cache(Class<V> clazz) {
        this(clazz, "id");
    }

    public List<MetaData> addAll(List<V> items) {

        List<MetaData> metaData = new ArrayList<>();

        for (V item : items) {
            Tuple2<K, MetaData> tuple = addItem(item);
            // ignore if only 1 item (id is always by default)
            if (tuple._2.getData().size() == 1) continue;
            metaData.add(tuple._2);
            //noinspection unchecked
            cache.put(tuple._1, item);
        }

        return metaData;
    }

    public Optional<MetaData> add(V item) {
        Tuple2<K, MetaData> tuple = addItem(item);
        // ignore if only 1 item (id is always by default)
        if (tuple._2.getData().size() > 1) {
            cache.put(tuple._1, item);
            return Optional.of(tuple._2);
        }
        return Optional.empty();
    }

    @SuppressWarnings("SuspiciousMethodCalls")
    private Tuple2<K, MetaData> addItem(V item) {
        if (item == null) throw new IllegalArgumentException("Argument can not be null");
        try {
            MetaData data = new MetaData();
            Field[] fields = item.getClass().getDeclaredFields();
            Object key = getValue(keyFieldName, item);

            for (Field field : fields) {

                if (deltaIgnore(field)) continue;

                Object fieldValue = getValue(field, item);
                String fieldName = field.getName();
                if (cache.containsKey(key)) {
                    Object cachedValue = getValue(fieldName, cache.get(key));
                    Object givenObject = getValue(field, item);
                    if (!cachedValue.equals(givenObject) || fieldName.equals(keyFieldName)) {
                        data.add(fieldName, givenObject);
                    }
                } else {
                    data.add(field.getName(), fieldValue);
                }
            }

            return tuple(key, data);

        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private Object getValue(Field field, V param) throws IllegalAccessException {
        field.setAccessible(true);
        validateType(field);
        return field.get(param);
    }

    private Object getValue(String fieldName, V param) throws NoSuchFieldException, IllegalAccessException {
        Field field = param.getClass().getDeclaredField(fieldName);
        return getValue(field, param);
    }

    private void validateType(Field field) {
        if (!model.values().contains(field.getType())) throw new IllegalArgumentException(field.getType().getSimpleName() + " not supported");
    }

    private boolean deltaIgnore(Field field) {
        Annotation[] annotations = field.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(DeltaIgnore.class)) return true;
        }
        return false;
    }

}
