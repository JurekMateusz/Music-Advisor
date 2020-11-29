package com.example.musicadvisor.formater;

import com.example.musicadvisor.formater.filebuilder.FileBuilder;
import com.example.musicadvisor.formater.filebuilder.format.json.JsonFileBuilder;
import com.example.musicadvisor.formater.filebuilder.format.xml.XmlFileBuilder;
import com.google.common.collect.ImmutableMap;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Optional;

public class FileBuilderFactory {
    private static ImmutableMap<String, String> map;

    static {
        map = ImmutableMap.<String, String>builder()
                .put("JSON", JsonFileBuilder.class.getName())
                .put("XML", XmlFileBuilder.class.getName())
                .build();
    }

    public static Optional<FileBuilder> get(String type) {
        String classToCreate = getFromMap(type);
        if (Objects.isNull(classToCreate)) return Optional.empty();
        FileBuilder instance = getInstance(classToCreate);
        return Optional.ofNullable(instance);
    }

    private static String getFromMap(String type) {
        String formatted = type.trim().toUpperCase();
        String classToCreate = map.get(formatted);
        return classToCreate;
    }

    private static FileBuilder getInstance(String classToCreate) {
        try {
            Constructor<?> ctor = getConstructor(classToCreate);
            return (FileBuilder) ctor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Constructor<?> getConstructor(String classToCreate) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazz = Class.forName(classToCreate);
        return clazz.getConstructor();
    }
}
