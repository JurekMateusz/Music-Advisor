package com.example.musicadvisor.api.model.album;

import com.example.musicadvisor.api.model.Artist;
import com.example.musicadvisor.api.model.ExternalUrls;
import com.example.musicadvisor.api.model.Image;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class Album {
    @JsonProperty("album_type")
    private String albumType;
    private List<Artist> artists;
    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;
    private String href;
    private String id;
    private List<Image> images;
    private String name;
    private Integer popularity;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("total_tracks")
    private Integer totalTracks;
    private Tracks tracks;
    private String type;
    private String uri;
}
