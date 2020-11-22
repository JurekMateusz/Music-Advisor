package com.example.musicadvisor.api.model;

import lombok.Getter;

@Getter
public class Image {
    public Integer height;
    public String url;
    public Integer width;

    @Override
    public String toString() {
        return url;
    }
}
