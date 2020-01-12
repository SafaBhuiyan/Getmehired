package com.example.getmehiredsocial.service;

import com.example.getmehiredsocial.model.Photo;
import com.example.getmehiredsocial.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    PhotoRepository photoRepository;
    public List<Photo> getPhotos(){
        return photoRepository.findAll();
    }

    public void save(Photo photo) {
        photoRepository.save(photo);
    }

    public void edit(Photo photo) {
        photoRepository.save(photo);
    }

    public void delete(String id) {
        photoRepository.deleteById(id);
    }
}
