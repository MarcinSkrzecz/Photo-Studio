package com.marcin.photo_studio.domain.photo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PhotoDto {

    private Long id;
    private Long galleryId;
    private String photoName;
    private byte[] photo;

    public PhotoDto(Long id, Long galleryId, String photoName, byte[] photo) {
        this.id = id;
        this.galleryId = galleryId;
        this.photoName = photoName;
        this.photo = photo;
    }

    public PhotoDto(Long galleryId, String photoName, byte[] photo) {
        this.galleryId = galleryId;
        this.photoName = photoName;
        this.photo = photo;
    }
}
