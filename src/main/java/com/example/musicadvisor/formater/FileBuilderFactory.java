package com.example.musicadvisor.formater;

import com.example.musicadvisor.formater.filebuilder.FileBuilder;
import com.example.musicadvisor.formater.filebuilder.FileBuilderTemple;
import com.example.musicadvisor.formater.filebuilder.json.JsonFileBuilder;
import com.example.musicadvisor.formater.filebuilder.xml.XmlFileBuilder;
import com.google.common.collect.ImmutableMap;

import java.util.Optional;

public class FileBuilderFactory {
    private static ImmutableMap<String, FileBuilder> map;

    static {
        map = ImmutableMap.<String, FileBuilder>builder()
                .put("JSON", new JsonFileBuilder())
                .put("XML", new XmlFileBuilder())
                .build();
    }

    public static Optional<FileBuilder> get(String builder) {
        String formatted = builder.trim().toUpperCase();
        return Optional.ofNullable(map.get(formatted));
    }
}
