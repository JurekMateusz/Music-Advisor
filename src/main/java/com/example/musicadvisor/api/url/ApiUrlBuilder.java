package com.example.musicadvisor.api.url;

import org.springframework.stereotype.Repository;

@Repository
public class ApiUrlBuilder {
    private static String DEFAULT_COUNTRY = "PL";
    private static int NUMBER_OF_ENTRIES_PER_PAGE = 16;
    private static String NEW_RELEASES_BASE_URL = "https://api.spotify.com/v1/browse/new-releases";

    public String newReleases(int page) {
        if (page <= 0) return buildNewReleasesUrl(0);
        return buildNewReleasesUrl(page * NUMBER_OF_ENTRIES_PER_PAGE);
    }

    private String buildNewReleasesUrl(int page) {
        return NEW_RELEASES_BASE_URL +
                "?" +
                "country=" +
                DEFAULT_COUNTRY +
                "&limit=" +
                NUMBER_OF_ENTRIES_PER_PAGE +
                "&offset=" +
                page;
    }

    public String album(String id) {
        return "https://api.spotify.com/v1/albums/" + id + "?limit=" + 50;
    }
}
