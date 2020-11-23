package com.example.musicadvisor.formater;

import com.example.musicadvisor.formater.filebuilder.FileBuilder;
import com.example.musicadvisor.formater.filebuilder.format.json.JsonFileBuilder;
import com.example.musicadvisor.formater.filebuilder.format.xml.XmlFileBuilder;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FileBuilderFactoryTest {

    @Test
    void Should_ReturnInstanceJsonFormatter_When_GivenStringIsJson() {
        String[] input = new String[]{"json", "JsoN", " JsoN ", "JSON"};
        for (String s : input) {
            Optional<FileBuilder> instance = FileBuilderFactory.get(s);

            assertTrue(instance.isPresent());
            assertTrue(instance.get() instanceof JsonFileBuilder);
        }
    }

    @Test
    void Should_ReturnInstanceXmlFormatter_WhenGivenStringXml(){
        String[] input = new String[]{"xml", "xml ", " XML ", " xMl"};
        for (String s : input) {
            Optional<FileBuilder> instance = FileBuilderFactory.get(s);

            assertTrue(instance.isPresent());
            assertTrue(instance.get() instanceof XmlFileBuilder);
        }
    }
    @Test
    void Should_ReturnEmptyOptional_WhenGivenStringWrongString(){
        String[] input = new String[]{"x l", "jsson ", "  ", ""};
        for (String s : input) {
            Optional<FileBuilder> instance = FileBuilderFactory.get(s);

            assertTrue(instance.isEmpty());
        }
    }
}
