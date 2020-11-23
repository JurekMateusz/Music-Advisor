package com.example.musicadvisor.service;

import com.example.musicadvisor.api.ApiFacadeImpl;
import com.example.musicadvisor.api.model.album.Album;
import com.example.musicadvisor.exceptions.NotGivenParamInUriException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AlbumServiceTest {
    @Spy
    private Model model;
    @Mock
    private ApiFacadeImpl api;

    private AlbumService albumService;

    @BeforeEach
    void setUp() {
        albumService = new AlbumService(api);
    }

    @Test
    void Should_ThrowException_When_EmptyOptionalIsPassed() {
        Exception exception = assertThrows(NotGivenParamInUriException.class, () -> {
            albumService.fetchDataToModelForPlaylist(model, Optional.empty());
        });
        String expectedMessage = "No param";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void Should_ReturnFalse_When_ApiReturnEmptyResult() {
        //given
        String albumId = "id2432";
        Optional<String> idInput = Optional.of(albumId);
        when(api.getAlbum(anyString())).thenReturn(Optional.empty());

        //when
        boolean result = albumService.fetchDataToModelForPlaylist(model, idInput);

        //then
        assertFalse(result);
    }

    @Test
    void Should_FetchModelAndReturnTrue_When_ApiReturnNonEmptyOptional() {
        //given
        String albumId = "id2432";
        Optional<String> idInput = Optional.of(albumId);
        Optional<Album> album = Optional.of(new Album());
        when(api.getAlbum(anyString())).thenReturn(album);

        //when
        boolean result = albumService.fetchDataToModelForPlaylist(model, idInput);

        //then
        assertTrue(result);
    }

}
