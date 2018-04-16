package com.kozlowst.microcache;

import java.lang.reflect.Field;
import java.util.*;

public class Cache<K, V> extends HashMap<K, V> {

    private Map<String, Class> model;
    private String keyFieldName;

    public Cache(Class<V> clazz, String keyFieldName) {
        model = new HashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            model.put(field.getName(), field.getType());
        }
        this.keyFieldName = keyFieldName;
    }

    public List<MetaData> addAll(List<V> items) {

        List<MetaData> metaData = new ArrayList<>();
        Set<String> names = model.keySet();

        try {
            for (V item : items) {
                MetaData data = new MetaData();
                Object key = getValue(keyFieldName, item);
                if (containsKey(key)) {
                    V v = get(key);
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

                metaData.add(data);
                //noinspection unchecked
                put((K) key, item);

            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new IllegalArgumentException(e);
        }

        return metaData;
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
