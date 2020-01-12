package com.example.getmehiredsocial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Users")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String profilePhotoUrl;
}
