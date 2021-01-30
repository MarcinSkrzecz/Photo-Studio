package com.marcin.photo_studio.domain.gallery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GalleryDto {

    private Long id;
    private Long userId;
    private String galleryName;

    public GalleryDto(Long id, Long userId, String galleryName) {
        this.id = id;
        this.userId = userId;
        this.galleryName = galleryName;
    }

    public GalleryDto(Long userId, String galleryName) {
        this.userId = userId;
        this.galleryName = galleryName;
    }
}
