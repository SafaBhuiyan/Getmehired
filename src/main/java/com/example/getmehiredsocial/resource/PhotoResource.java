package com.example.getmehiredsocial.resource;

import com.example.getmehiredsocial.exception.InvalidAlbumIdException;
import com.example.getmehiredsocial.exception.InvalidPhotoIdException;
import com.example.getmehiredsocial.model.Album;
import com.example.getmehiredsocial.model.Photo;
import com.example.getmehiredsocial.model.User;
import com.example.getmehiredsocial.repository.AlbumRepository;
import com.example.getmehiredsocial.service.AlbumService;
import com.example.getmehiredsocial.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Photos")
public class PhotoResource {
    @Autowired
    PhotoService photoService;
    @Autowired
    AlbumService albumService;
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping
    public List<Photo> getPhotos() {
        return photoService.getPhotos();
    }

    @PostMapping
    public void savePhoto(@RequestBody Photo photo) {
        photoService.save(photo);
    }



    @PutMapping("/{photoId}")
    public void editPhoto(@RequestBody Photo photo, @PathVariable("photoId") String photoId) throws Exception {
            Photo oldPhoto = photoService.getByPhotoId(photoId);
            photo.setPhotoId(oldPhoto.getPhotoId());
            List<Album> album = albumRepository.findAll();
            for(Album albumObject: album) {
                if (albumObject.getAlbumId().equals(photo.getAlbumId())) {
                    photoService.edit(photo);
                } else {
                    throw new InvalidAlbumIdException("Invalid Album Id given Please enter valid Album Id");
                }
            }
    }




    //photo.getAlbumId().equals(albumRepository.findByAlbumId(albumId).);

    //throw new InvalidPhotoIdException("Invalid Photo Id given, Please enter valid Photo Id");



/*
    @PutMapping("/{photoId}")
    public void editPhoto(@RequestBody Photo photo,@PathVariable("photoId") String photoId){
        photo.setPhotoId(photoId);
        photoService.edit(photo);
    }*/

    @DeleteMapping("/{photoId}")
    public void deletePhoto(@PathVariable("photoId") String photoId) {
        photoService.delete(photoId);
    }

}

