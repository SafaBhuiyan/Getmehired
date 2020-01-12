package com.example.getmehiredsocial.repository;

import com.example.getmehiredsocial.model.Album;
import com.example.getmehiredsocial.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends MongoRepository<Album, String> {
    Album findByName(String s);
}
