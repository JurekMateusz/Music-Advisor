package com.example.musicadvisor.formater.filebuilder;

import com.example.musicadvisor.api.model.album.Album;
import com.example.musicadvisor.model.file.FileData;

public interface FileBuilder {
    FileData build(Album album);
}
