package com.example.getmehiredsocial.resource;

import com.example.getmehiredsocial.model.Photo;
import com.example.getmehiredsocial.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Photos")
public class PhotoResource {
    @Autowired
    PhotoService photoService;

    @GetMapping
  public List<Photo> getPhotos(){
        return photoService.getPhotos();
    }

    @PostMapping
    public void savePhoto(@RequestBody Photo photo){
        photoService.save(photo);
    }

    @PutMapping("/{id}")
    public void editPhoto(@RequestBody Photo photo,@PathVariable("id") String id){
        photo.setId(id);
        photoService.edit(photo);
    }

    @DeleteMapping("/{id}")
    public void deletePhoto(@PathVariable("id") String id){
        photoService.delete(id);
    }


}
