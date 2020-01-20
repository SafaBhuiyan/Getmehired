package com.example.getmehiredsocial.resource;

import com.example.getmehiredsocial.exception.InvalidAlbumIdException;
import com.example.getmehiredsocial.model.Album;
import com.example.getmehiredsocial.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/Albums")
public class AlbumResource {
    @Autowired
    AlbumService albumService;

    @GetMapping
    public List<Album> getAlbums(){
        return albumService.getAlbums();
    }

    @PostMapping
    public void saveAlbum(@Valid @RequestBody Album album){
        albumService.save(album);
    }

    @PutMapping("/{albumId}")
    public void editAlbum(@RequestBody Album album,@PathVariable("albumId") String albumId){
        album.setAlbumId(albumId);
        albumService.edit(album);

    }
    @DeleteMapping("/{albumId}")
    public void deleteAlbumWithPhotosComments(@PathVariable("albumId") String albumId){
        albumService.delete(albumId);
    }

    @DeleteMapping("/dOnlyAlbums/{albumId}")
    public void deleteAlbumOnly(@PathVariable("albumId") String albumId){
        albumService.deleteById(albumId);

    }


}

