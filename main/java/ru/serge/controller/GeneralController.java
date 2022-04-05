package ru.serge.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.serge.repository.AlbumRepository;
import ru.serge.repository.ArtistRepository;

@RestController
@RequestMapping("/api")
@Slf4j
public class GeneralController {
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;

    public GeneralController(AlbumRepository albumRepository, ArtistRepository artistRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
    }

    @GetMapping("/albums")
    public ResponseEntity getAlbums() {
        log.info("Get request for albums");
        return new ResponseEntity(albumRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/artists")
    public ResponseEntity getArtists() {
        log.info("Get request for artists");
        return new ResponseEntity(artistRepository.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/artist/{id}")
    public ResponseEntity deleteArtist(@PathVariable Integer id) {
        artistRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/album/{id}")
    public ResponseEntity deleteAlbum(@PathVariable Integer id) {
        albumRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
