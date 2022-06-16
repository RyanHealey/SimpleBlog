package com.ryanhealey.simpleblogbackend.controllers;

import com.ryanhealey.simpleblogbackend.dto.CommentDto;
import com.ryanhealey.simpleblogbackend.dto.PostDto;
import com.ryanhealey.simpleblogbackend.service.CommentService;
import com.ryanhealey.simpleblogbackend.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(
        value = "/comments",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class CommentController extends BlogController<CommentDto, CommentService>{
    public CommentController(CommentService service) {
        super(service);
    }

    @GetMapping(value="/post/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDto> getCommentsByPostId(@PathVariable UUID postId){
        return this.getService().getByPostId(postId);
    }
}
