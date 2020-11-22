package com.example.musicadvisor.api.model.album;

import com.example.musicadvisor.api.model.Artist;
import com.example.musicadvisor.api.model.ExternalUrls;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import java.util.List;

@Getter
@JsonPropertyOrder({
        "artists",
        "available_markets",
        "disc_number",
        "duration_ms",
        "explicit",
        "external_urls",
        "href",
        "id",
        "is_local",
        "name",
        "preview_url",
        "track_number",
        "type",
        "uri"
})
public class Item {
    private List<Artist> artists;
    @JsonProperty("disc_number")
    private Integer discNumber;
    @JsonProperty("duration_ms")
    private Integer durationMs;
    @JsonProperty("explicit")
    private Boolean explicit;
    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;
    private String href;
    private String id;
    @JsonProperty("is_local")
    private Boolean isLocal;
    private String name;
    @JsonProperty("preview_url")
    private String previewUrl;
    @JsonProperty("track_number")
    private Integer trackNumber;
    private String type;
    private String uri;
}
