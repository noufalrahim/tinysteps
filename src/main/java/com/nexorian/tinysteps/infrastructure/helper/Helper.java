package com.nexorian.tinysteps.infrastructure.helper;

import java.lang.reflect.Field;

public final class Helper {

    private Helper() {}

    public static <T> void mergeNonNullProperties(T source, T target) {
        if (source == null || target == null) {
            return;
        }

        Class<?> clazz = source.getClass();

        while (clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    Object value = field.get(source);
                    if (value != null && !field.getName().equals("id")) {
                        field.set(target, value);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(
                        "Failed to merge field: " + field.getName(), e
                    );
                }
            }
            clazz = clazz.getSuperclass();
        }
    }
}
