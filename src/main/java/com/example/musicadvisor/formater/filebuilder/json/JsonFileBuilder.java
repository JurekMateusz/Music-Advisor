package com.example.musicadvisor.formater.filebuilder.json;

import com.example.musicadvisor.api.model.album.Album;
import com.example.musicadvisor.formater.filebuilder.FileBuilderTemple;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.core.io.ByteArrayResource;

public class JsonFileBuilder extends FileBuilderTemple {
    private Gson parser;

    public JsonFileBuilder() {
        this.parser = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    protected String getFileExtension() {
        return "json";
    }

    @Override
    protected ByteArrayResource getByteArrayResourceInSpecificFormat(Album album) {
        String json = parser.toJson(album);
        byte[] jsonInBytes = json.getBytes();
        return new ByteArrayResource(jsonInBytes);
    }
}
