package com.example.musicadvisor.controller;

import com.example.musicadvisor.model.file.FileData;
import com.example.musicadvisor.service.AlbumService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Optional;

@Controller
public class AlbumController {
    private AlbumService service;

    public AlbumController(AlbumService service) {
        this.service = service;
    }

    @GetMapping("/album")
    public String getPlaylist(Model model, @RequestParam("id") Optional<String> album) {
        boolean isSuccess = service.fetchDataToModelForPlaylist(model, album);
        if (!isSuccess) {
            return "redirect:/new-releases";
        }
        return "album";
    }

    @GetMapping("/album/download")
    public ResponseEntity<Resource> downloadAlbum(@RequestParam("id") Optional<String> album,
                                                  @RequestParam("type") Optional<String> type){
        FileData file = service.getDataToDownLoad(album, type);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
                        + "DATA."+file.getFileExtension() + "\"")
                .body(file.getResource());
    }


}
