package com.example.musicadvisor.service;

import com.example.musicadvisor.api.ApiFacade;
import com.example.musicadvisor.api.model.Image;
import com.example.musicadvisor.api.model.albums.Albums;
import com.example.musicadvisor.model.pagination.Pagination;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NewReleasesService {
    private ApiFacade api;
    private PaginationBuilder createPagination;

    public void fetchDataToModel(Model model, int page) {
        Albums newReleases = api.getNewReleases(page);
        removeUnnecessaryImages(newReleases);
        addQuotesInAlbumTitles(newReleases);
        Pagination pagination = createPagination.createPagination(newReleases);
        model.addAttribute("albums", newReleases.getAlbums());
        model.addAttribute("pagination", pagination);
    }

    private void removeUnnecessaryImages(Albums newReleases) {
        newReleases.getAlbums().forEach(item -> {
            List<Image> oneImage = item.getImages()
                    .stream()
                    .filter(image -> image.height == 300)
                    .collect(Collectors.toList());
            item.setImages(oneImage);
        });
    }

    private void addQuotesInAlbumTitles(Albums newReleases) {
        newReleases.getAlbums().forEach(item -> {
            String name = "\"" + item.getName() + "\"";
            item.setName(name);
        });
    }
}
