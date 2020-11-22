package com.example.musicadvisor.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ExternalUrls {
    @JsonProperty("spotify")
    private String spotifyUrl;

    @Override
    public String toString() {
        return spotifyUrl;
    }
}
