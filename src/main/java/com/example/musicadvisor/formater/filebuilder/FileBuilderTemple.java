package com.example.musicadvisor.formater.filebuilder;

import com.example.musicadvisor.api.model.album.Album;
import com.example.musicadvisor.formater.filebuilder.mapper.Mapper;
import com.example.musicadvisor.formater.filebuilder.model.MusicAdvisor;
import com.example.musicadvisor.formater.filebuilder.model.album.AlbumDownload;
import com.example.musicadvisor.model.file.FileData;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.lang.NonNull;

public abstract class FileBuilderTemple implements FileBuilder {
    private Mapper mapper = new Mapper();

    @Override
    public FileData build(@NonNull Album album) {
        AlbumDownload albumDownload = mapper.map(album);

        String fileExtension = getFileExtension();
        ByteArrayResource resource = getByteArrayResourceInSpecificFormat(albumDownload);
        return FileData.of(fileExtension, resource);
    }

    protected abstract String getFileExtension();

    protected abstract ByteArrayResource getByteArrayResourceInSpecificFormat(MusicAdvisor musicAdvisor);
}
