package com.example.musicadvisor.model.file;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.io.ByteArrayResource;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FileData {
    private String fileExtension;
    private ByteArrayResource resource;

    public static FileData of(String fileExtension, ByteArrayResource byteArrayResource) {
        return new FileData(fileExtension, byteArrayResource);
    }
}
