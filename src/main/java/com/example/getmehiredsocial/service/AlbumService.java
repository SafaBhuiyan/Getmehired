package com.example.getmehiredsocial.service;

import com.example.getmehiredsocial.model.Album;
import com.example.getmehiredsocial.model.Photo;
import com.example.getmehiredsocial.repository.AlbumRepository;
import com.example.getmehiredsocial.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumService {
    @Autowired
    AlbumRepository albumRepository;


    public List<Album> getAlbums() {
        return albumRepository.findAll();
    }

    public void save(Album album) {
        albumRepository.save(album);

    }


    public void edit(Album album) {
        albumRepository.save(album);
    }

    public void delete(String id) {
        albumRepository.deleteById(id);

    }
}