package com.marcin.photo_studio.controller;

import com.marcin.photo_studio.domain.photo.Photo;
import com.marcin.photo_studio.domain.photo.PhotoDto;
import com.marcin.photo_studio.mapper.PhotoMapper;
import com.marcin.photo_studio.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1")
public class PhotoController {
    @Autowired
    private PhotoMapper mapper;
    @Autowired
    private PhotoService service;

    @RequestMapping(method = RequestMethod.GET, value = "/photo")
    public List<PhotoDto> getAllPhotos() {
        return mapper.mapToPhotoDto(service.getAllPhotos());
    }
    @RequestMapping(method = RequestMethod.GET, value = "/photo/{photoId}")
    public PhotoDto getPhoto(@RequestParam Long photoId) {
        return mapper.mapToPhotoDto(service.getPhoto(photoId));
    }
    @RequestMapping(method = RequestMethod.POST, value = "/photo", consumes = APPLICATION_JSON_VALUE)
    public void createPhoto(@RequestBody PhotoDto photoDto) {
        service.createPhoto(mapper.mapToPhoto(photoDto));
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/photo")
    public PhotoDto updatePhotoName(@RequestParam Long photoId, @RequestParam String newPhotoName) {
        return mapper.mapToPhotoDto(service.updatePhotoName(photoId, newPhotoName));
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/photo/{photoId}")
    public void deletePhoto(@RequestParam Long photoId) {
        service.deletePhoto(photoId);
    }
}