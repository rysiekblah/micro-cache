package com.kozlowst.microcache;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Cache<K, V> {

    private Map<K, V> cache;
    private Map<String, Class> model;
    private String keyFieldName;
    private Set<String> names;

    public Cache(Class<V> clazz, String keyFieldName) {
        model = new HashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            model.put(field.getName(), field.getType());
        }
        this.names = model.keySet();
        this.keyFieldName = keyFieldName;
        this.cache = new ConcurrentHashMap<>();
    }

    public List<MetaData> addAll(List<V> items) {

        List<MetaData> metaData = new ArrayList<>();

        for (V item : items) {
            Pair<K, MetaData> pair = add(item);
            metaData.add(pair.getValue());
            //noinspection unchecked
            cache.put((K) pair.getKey(), item);
        }

        return metaData;
    }

    @SuppressWarnings("SuspiciousMethodCalls")
    public Pair<K, MetaData> add(V item) {
        if (item == null) throw new IllegalArgumentException("Argument can not be null");
        try {
            MetaData data = new MetaData();
            Object key = getValue(keyFieldName, item);
            if (cache.containsKey(key)) {
                V v = cache.get(key);
                for (String name : names) {
                    Object obj = getValue(name, item);
                    Object obj1 = getValue(name, v);
                    if (!obj.equals(obj1) || name.equals(keyFieldName))
                        data.add(name, obj);
                }
            } else {
                for (String name : names) {
                    Object obj = getValue(name, item);
                    data.add(name, obj);
                }
            }

            return new Pair<>((K)key, data);

        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private Object getValue(String paramName, V param) throws NoSuchFieldException, IllegalAccessException {
        Field field = param.getClass().getDeclaredField(paramName);
        field.setAccessible(true);
        validateType(field);
        return field.get(param);
    }

    private void validateType(Field field) {
        if (!model.values().contains(field.getType())) throw new IllegalArgumentException(field.getType().getSimpleName() + " not supported");
    }

}
