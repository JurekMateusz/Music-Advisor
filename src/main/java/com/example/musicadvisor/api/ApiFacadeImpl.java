package com.example.musicadvisor.api;

import com.example.musicadvisor.api.model.album.Album;
import com.example.musicadvisor.api.model.albums.Albums;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ApiFacadeImpl implements ApiFacade {
    private RequestApi request;
    private ApiUrlBuilder urlBuilder;

    public ApiFacadeImpl(RequestApi request, ApiUrlBuilder urlBuilder) {
        this.request = request;
        this.urlBuilder = urlBuilder;
    }

    @Override
    public Albums getNewReleases(int page) {
        String url = urlBuilder.newReleases(page - 1);
        Optional<Albums> newReleases = request.getNewReleases(url);
        return newReleases.orElse(Albums.empty());
    }

    @Override
    public Optional<Album> getAlbum( String id) {
        String url = urlBuilder.album(id);
        Optional<Album> album = request.getAlbum(url);
        return album;
    }

}
