package com.example.musicadvisor.formater.filebuilder.model.album;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({
        "name",
        "linkToTrack",
        "preview_url",
        "track_number",
        "duration_ms"
})
public class Track {
    private String name;
    @JsonProperty("listen_in_spotify")
    private String linkToTrack;
    @JsonProperty("preview_url")
    private String previewUrl;
    @JsonProperty("track_number")
    private Integer trackNumber;
    @JsonProperty("duration_ms")
    private Integer duration;
}
