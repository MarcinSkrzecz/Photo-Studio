package com.marcin.photo_studio.mapper;

import com.marcin.photo_studio.domain.gallery.Gallery;
import com.marcin.photo_studio.domain.gallery.GalleryDto;
import com.marcin.photo_studio.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GalleryMapper {
    @Autowired
    private UserRepository userRepository;

    public Gallery mapToGallery(final GalleryDto galleryDto) {
        return new Gallery(userRepository.findById(galleryDto.getUserId()).get(), galleryDto.getGalleryName());
    }

    public GalleryDto mapToGalleryDto(final Gallery gallery) {
        return new GalleryDto(
                gallery.getId(),
                gallery.getUser().getId(),
                gallery.getGalleryName()
        );
    }

    public List<GalleryDto> mapToGalleryDto(final List<Gallery> galleryList) {
        return galleryList.stream()
                .map(this::mapToGalleryDto)
                .collect(Collectors.toList());
    }
}
