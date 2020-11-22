package com.example.musicadvisor.formater.filebuilder.model.album;

import com.example.musicadvisor.formater.filebuilder.model.MusicAdvisor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JacksonXmlRootElement(localName = "album")
@JsonPropertyOrder({
        "name",
        "popularity",
        "totalTracks",
        "releaseDate",
        "externalUrls",
        "artists",
        "images",
        "tracks"})
public class AlbumDownload extends MusicAdvisor {
    private String name;
    private Integer popularity;
    private List<Artist> artists;
    @JsonProperty("album_in_spotify")
    private String externalUrls;
    private List<Image> images;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("total_tracks")
    private Integer totalTracks;
    private List<Track> tracks;
}
