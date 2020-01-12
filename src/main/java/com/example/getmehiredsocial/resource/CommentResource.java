package com.example.getmehiredsocial.resource;


import com.example.getmehiredsocial.model.Comment;
import com.example.getmehiredsocial.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Comments")
public class CommentResource {
    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> getCommnets(){
        return commentService.getComments();
    }

    @PostMapping
    public void saveComment(@RequestBody Comment comment){
        commentService.save(comment);
    }
    @PutMapping("/{id}")
    public void editComment(@RequestBody Comment comment, @PathVariable("id") String id){
        comment.setId(id);
        commentService.edit(comment);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable("id") String id){
        commentService.delete(id);
    }


}
