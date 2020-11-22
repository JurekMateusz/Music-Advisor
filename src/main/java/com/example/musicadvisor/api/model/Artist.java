package com.example.musicadvisor.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Artist {
    private String name;
    private String href;
    private String id;
    private String type;
    private String uri;
    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;

    @Override
    public String toString() {
        return name;
    }
}
