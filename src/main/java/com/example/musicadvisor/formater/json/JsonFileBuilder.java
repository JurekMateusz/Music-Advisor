package com.example.musicadvisor.formater.json;

import com.example.musicadvisor.api.model.album.Album;
import com.example.musicadvisor.formater.FileBuilder;
import com.example.musicadvisor.model.file.FileData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.core.io.ByteArrayResource;

public class JsonFileBuilder implements FileBuilder {
    private Gson parser;

    public JsonFileBuilder() {
        this.parser = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public FileData build(Album album) {
        String json = parser.toJson(album);
        byte[] jsonInBytes = json.getBytes();
        ByteArrayResource byteArrayResource = new ByteArrayResource(jsonInBytes);
        return FileData.of("json", byteArrayResource);
    }
}
