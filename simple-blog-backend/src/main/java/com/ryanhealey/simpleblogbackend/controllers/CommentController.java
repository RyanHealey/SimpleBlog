package com.ryanhealey.simpleblogbackend.controllers;

import com.ryanhealey.simpleblogbackend.dto.CommentDto;
import com.ryanhealey.simpleblogbackend.dto.PostDto;
import com.ryanhealey.simpleblogbackend.service.CommentService;
import com.ryanhealey.simpleblogbackend.service.PostService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
