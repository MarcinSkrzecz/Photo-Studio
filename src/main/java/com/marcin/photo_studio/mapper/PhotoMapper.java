package com.marcin.photo_studio.mapper;

import com.marcin.photo_studio.domain.gallery.GalleryRepository;
import com.marcin.photo_studio.domain.photo.Photo;
import com.marcin.photo_studio.domain.photo.PhotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PhotoMapper {
    @Autowired
    private GalleryRepository galleryRepository;

    public Photo mapToPhoto(final PhotoDto photoDto) {
        return new Photo(galleryRepository.findById(photoDto.getGalleryId()).get(), photoDto.getPhotoName(), photoDto.getPhoto());
    }

    public PhotoDto mapToPhotoDto(final Photo photo) {
        return new PhotoDto(
                photo.getId(),
                photo.getGallery().getId(),
                photo.getPhotoName(),
                photo.getPhoto()
        );
    }

    public List<PhotoDto> mapToPhotoDto(final List<Photo> photoList) {
        return photoList.stream()
                .map(this::mapToPhotoDto)
                .collect(Collectors.toList());
    }
}
