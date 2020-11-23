package com.example.musicadvisor.service;

import com.example.musicadvisor.api.ApiFacade;
import com.example.musicadvisor.api.ApiFacadeImpl;
import com.example.musicadvisor.api.model.album.Album;
import com.example.musicadvisor.exceptions.BadAlbumIdParamInUriException;
import com.example.musicadvisor.exceptions.NotGivenParamInUriException;
import com.example.musicadvisor.exceptions.NotSupportedFileFormatException;
import com.example.musicadvisor.formater.FileBuilderFactory;
import com.example.musicadvisor.formater.filebuilder.FileBuilder;
import com.example.musicadvisor.model.file.FileData;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;

@Service
public class AlbumService {
    private ApiFacade api;

    public AlbumService(ApiFacadeImpl api) {
        this.api = api;
    }

    public boolean fetchDataToModelForPlaylist(Model model, Optional<String> album) {
        String albumId = album.orElseThrow(() -> new NotGivenParamInUriException("No param"));
        Optional<Album> albumOpt = api.getAlbum(albumId);
        if (albumOpt.isEmpty()) {
            return false;
        }
        model.addAttribute("album", albumOpt.get());
        return true;
    }


    public FileData getDataToDownLoad(Optional<String> albumIdOpt, Optional<String> typeOpt) {
        String albumId = albumIdOpt.orElseThrow(() -> new NotGivenParamInUriException("Not given album id"));
        String type = typeOpt.orElseThrow(() -> new NotGivenParamInUriException("Not given type"));
        Optional<Album> albumFromApi = api.getAlbum(albumId);
        Album album = albumFromApi.orElseThrow(BadAlbumIdParamInUriException::new);
        Optional<FileBuilder> fileBuilder = FileBuilderFactory.get(type);
        FileBuilder builder = fileBuilder.orElseThrow(() -> new NotSupportedFileFormatException(type));
        return builder.build(album);
    }
}
