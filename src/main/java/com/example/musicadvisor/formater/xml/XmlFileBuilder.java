package com.example.musicadvisor.formater.xml;

import com.example.musicadvisor.api.model.album.Album;
import com.example.musicadvisor.formater.FileBuilder;
import com.example.musicadvisor.model.file.FileData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.core.io.ByteArrayResource;

public class XmlFileBuilder implements FileBuilder {
    private XmlMapper xmlMapper;

    public XmlFileBuilder() {
        this.xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    public FileData build(Album album) {
        String xml = "";
        try {
            xml = xmlMapper.writeValueAsString(album);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        byte[] bytes = xml.getBytes();
        ByteArrayResource resource = new ByteArrayResource(bytes);
        return FileData.of("xml", resource);
    }
}
