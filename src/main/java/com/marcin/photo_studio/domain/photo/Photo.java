package com.marcin.photo_studio.domain.photo;

import com.marcin.photo_studio.domain.gallery.Gallery;
import com.marcin.photo_studio.domain.user.User;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Photo")
public class Photo {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue
    @Column(name = "PHOTO_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "GALLERY_ID", referencedColumnName = "GALLERY_ID")
    private Gallery gallery;

    @Column(name = "PHOTO_NAME")
    private String photoName;

    @Lob
    @Column(name = "PHOTO")
    private byte[] photo;

    public Photo(Gallery gallery, String photoName, byte[] photo) {
        this.gallery = gallery;
        this.photoName = photoName;
        this.photo = photo;
    }
}
