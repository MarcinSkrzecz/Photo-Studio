package com.marcin.photo_studio.controller;

import com.marcin.photo_studio.domain.gallery.Gallery;
import com.marcin.photo_studio.domain.gallery.GalleryDto;
import com.marcin.photo_studio.mapper.GalleryMapper;
import com.marcin.photo_studio.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1")
public class GalleryController {
    @Autowired
    private GalleryMapper mapper;
    @Autowired
    private GalleryService service;

    @RequestMapping(method = RequestMethod.GET, value = "/gallery")
    public List<GalleryDto> getAllGalleries() {
        return mapper.mapToGalleryDto(service.getAllGalleries());
    }
    @RequestMapping(method = RequestMethod.GET, value = "/gallery/{galleryId}")
    public GalleryDto getGallery(@RequestParam Long galleryId) {
        return mapper.mapToGalleryDto(service.getGallery(galleryId));
    }
    @RequestMapping(method = RequestMethod.POST, value = "/gallery", consumes = APPLICATION_JSON_VALUE)
    public void createGallery(@RequestBody GalleryDto galleryDto) {
        service.createGallery(mapper.mapToGallery(galleryDto));
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/gallery")
    public GalleryDto updateGalleryName(@RequestParam Long galleryId, @RequestParam String galleryName) {
        return mapper.mapToGalleryDto(service.updateGalleryName(galleryId, galleryName));
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/gallery/{galleryId}")
    public void deleteGallery(@RequestParam Long galleryId) {
        service.deleteGallery(galleryId);
    }
}