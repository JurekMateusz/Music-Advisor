package com.example.musicadvisor.formater.filebuilder.format.json;

import com.example.musicadvisor.formater.filebuilder.FileBuilderTemplate;
import com.example.musicadvisor.formater.filebuilder.model.MusicAdvisor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.core.io.ByteArrayResource;

public class JsonFileBuilder extends FileBuilderTemplate {
    private Gson parser;

    public JsonFileBuilder() {
        this.parser = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    protected String getFileExtension() {
        return "json";
    }

    @Override
    protected ByteArrayResource getByteArrayResourceInSpecificFormat(MusicAdvisor data) {
        String json = parser.toJson(data);
        byte[] jsonInBytes = json.getBytes();
        return new ByteArrayResource(jsonInBytes);
    }
}
