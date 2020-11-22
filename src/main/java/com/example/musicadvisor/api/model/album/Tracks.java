package com.example.musicadvisor.api.model.album;

import lombok.Getter;

import java.util.List;

@Getter
public class Tracks {
    private String href;
    private List<Item> items;
    private Integer limit;
    private String next;
    private Integer offset;
    private String previous;
    private Integer total;
}
