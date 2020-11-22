package com.example.musicadvisor.api.model.albums;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "href",
        "items",
        "limit",
        "next",
        "offset",
        "previous",
        "total"
})
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Albums {
    private String href;

    @JsonProperty("items")
    private List<Item> albums;

    private String next;
    private int offset;
    private String previous;
    private int total;
    private int limit;

    public static Albums empty() {
        return Albums.builder()
                .href("default link")
                .next("default next")
                .previous("default previous")
                .albums(Collections.emptyList())
                .build();
    }
}
