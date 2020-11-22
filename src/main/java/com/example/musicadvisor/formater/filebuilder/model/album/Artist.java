package com.example.musicadvisor.formater.filebuilder.model.album;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Artist {
    private String name;
    @JsonProperty("external_urls")
    private String url;
}
