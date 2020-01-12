package com.example.getmehiredsocial.resource;

import com.example.getmehiredsocial.model.User;
import com.example.getmehiredsocial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Users")
public class UserResource {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public void saveUser(@RequestBody User user){
        userService.save(user);
    }
    @PutMapping("/{id}")
    public void editUser(@RequestBody User user,@PathVariable ("id") String id){
        user.setId(id);
        userService.edit(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") String id){
        userService.delete(id);
    }
}
