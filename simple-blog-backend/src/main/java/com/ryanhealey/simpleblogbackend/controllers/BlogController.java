package com.ryanhealey.simpleblogbackend.controllers;

import com.ryanhealey.simpleblogbackend.dto.BlogDto;
import com.ryanhealey.simpleblogbackend.service.BlogService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public abstract class BlogController<D extends BlogDto, S extends BlogService> {
    private final S service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<D> getAll(){
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public D getById(@PathVariable UUID id){
        try{
            return (D) service.getById(id);
        }
        catch(FileNotFoundException e){
            throw new ResponseStatusException(  HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public UUID add(@RequestBody final D dto){
        return service.add(dto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable UUID id){
        try{
            service.delete(id);
        }
            catch(FileNotFoundException e){
            throw new ResponseStatusException(  HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    protected S getService(){
        return this.service;
    }

}
