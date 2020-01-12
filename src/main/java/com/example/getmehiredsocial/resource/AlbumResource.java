package com.example.getmehiredsocial.resource;

import com.example.getmehiredsocial.model.Album;
import com.example.getmehiredsocial.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void saveAlbum(@RequestBody Album album){
        albumService.save(album);
    }

    @PutMapping("/{id}")
    public void editAlbum(@RequestBody Album album,@PathVariable("id") String id){
        album.setId(id);
        albumService.edit(album);
    }
    @DeleteMapping("/{id}")
    public void deleteAlbum(@PathVariable("id") String id){
        albumService.delete(id);
    }
}
