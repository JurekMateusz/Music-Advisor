package com.example.musicadvisor.formater.filebuilder.xml;

import com.example.musicadvisor.api.model.album.Album;
import com.example.musicadvisor.formater.filebuilder.FileBuilderTemple;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.core.io.ByteArrayResource;

public class XmlFileBuilder extends FileBuilderTemple {
    private XmlMapper xmlMapper;

    public XmlFileBuilder() {
        this.xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    protected String getFileExtension() {
        return "xml";
    }

    @Override
    protected ByteArrayResource getByteArrayResourceInSpecificFormat(Album album) {
        String xml = "";
        try {
            xml = xmlMapper.writeValueAsString(album);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        byte[] bytes = xml.getBytes();
        return new ByteArrayResource(bytes);
    }
}
