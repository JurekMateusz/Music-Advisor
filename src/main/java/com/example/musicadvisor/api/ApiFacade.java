package com.example.musicadvisor.api;

import com.example.musicadvisor.api.model.album.Album;
import com.example.musicadvisor.api.model.albums.Albums;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ApiFacade {
    Albums getNewReleases(int page);

    Optional<Album> getAlbum( String id);
}
