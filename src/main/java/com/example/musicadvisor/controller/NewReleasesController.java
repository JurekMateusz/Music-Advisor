package com.example.musicadvisor.controller;

import com.example.musicadvisor.service.NewReleasesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class NewReleasesController {
    private NewReleasesService service;

    @GetMapping("/new-releases")
    public String getNewReleases(Model model, @RequestParam("page") Optional<Integer> page) {
        int currentPage = page.orElse(0);
        service.fetchDataToModel(model, currentPage);
        return "new-releases";
    }
}
