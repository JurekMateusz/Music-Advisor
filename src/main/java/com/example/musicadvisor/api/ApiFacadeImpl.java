package com.example.musicadvisor.api;

import com.example.musicadvisor.api.model.album.Album;
import com.example.musicadvisor.api.model.albums.Albums;
import com.example.musicadvisor.api.model.albums.AlbumsRoot;
import com.example.musicadvisor.api.url.ApiUrlBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ApiFacadeImpl implements ApiFacade {
    private RequestApi request;
    private ApiUrlBuilder urlBuilder;

    @Override
    public Albums getNewReleases(int page) {
        String url = urlBuilder.newReleases(page - 1);
        Optional<AlbumsRoot> root = (Optional<AlbumsRoot>) request.getCollection(AlbumsRoot.class, url);
        AlbumsRoot albumsRoot = root.orElseThrow(IllegalStateException::new);
        return albumsRoot.getAlbums();
    }

    @Override
    public Optional<Album> getAlbum(String id) {
        String url = urlBuilder.album(id);
        Optional<Album> collection = (Optional<Album>) request.getCollection(Album.class, url);
        return collection;
    }
}
