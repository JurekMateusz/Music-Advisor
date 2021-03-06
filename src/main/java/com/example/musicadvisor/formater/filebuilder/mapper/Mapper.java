package com.example.musicadvisor.formater.filebuilder.mapper;

import com.example.musicadvisor.api.model.album.Album;
import com.example.musicadvisor.api.model.album.Item;
import com.example.musicadvisor.formater.filebuilder.model.album.AlbumDownload;
import com.example.musicadvisor.formater.filebuilder.model.album.Track;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
public class Mapper {
    private ModelMapper mapper;

    public Mapper() {
        this.mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        mapper.typeMap(Album.class, AlbumDownload.class).addMappings(mapper -> {
            mapper.map(album -> album.getTracks().getItems(), AlbumDownload::setTracks);
        });
        mapper.typeMap(Item.class, Track.class).addMappings(mapper -> {
            mapper.map(item -> item.getExternalUrls().getSpotifyUrl(), Track::setLinkToTrack);
            mapper.map(Item::getDurationMs, Track::setDuration);
        });
    }

    public AlbumDownload map(Album album) {
        return mapper.map(album, AlbumDownload.class);
    }
}
