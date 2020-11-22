package com.example.musicadvisor.formater.filebuilder.format.xml;

import com.example.musicadvisor.formater.filebuilder.FileBuilderTemple;
import com.example.musicadvisor.formater.filebuilder.model.MusicAdvisor;
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
    protected ByteArrayResource getByteArrayResourceInSpecificFormat(MusicAdvisor data) {
        String xml = "";
        try {
            xml = xmlMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        byte[] bytes = xml.getBytes();
        return new ByteArrayResource(bytes);
    }
}
