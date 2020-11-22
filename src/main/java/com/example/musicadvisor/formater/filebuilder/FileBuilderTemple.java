package com.example.musicadvisor.formater.filebuilder;

import com.example.musicadvisor.api.model.album.Album;
import com.example.musicadvisor.formater.filebuilder.FileBuilder;
import com.example.musicadvisor.model.file.FileData;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.lang.NonNull;

public abstract class FileBuilderTemple implements FileBuilder {
    @Override
    public FileData build(@NonNull Album album) {
        //todo convert album to file model data
        String fileExtension = getFileExtension();
        ByteArrayResource resource = getByteArrayResourceInSpecificFormat(album);
        return FileData.of(fileExtension, resource);
    }

    protected abstract String getFileExtension();

    protected abstract ByteArrayResource getByteArrayResourceInSpecificFormat(Album album);
}
