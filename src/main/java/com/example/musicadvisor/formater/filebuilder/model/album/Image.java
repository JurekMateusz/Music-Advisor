package com.example.musicadvisor.formater.filebuilder.model.album;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Image {
    public Integer height;
    public String url;
    public Integer width;

    @Override
    public String toString() {
        return url;
    }
}
