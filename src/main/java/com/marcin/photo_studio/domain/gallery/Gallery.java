package com.marcin.photo_studio.domain.gallery;

import com.marcin.photo_studio.domain.photo.Photo;
import com.marcin.photo_studio.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Gallery")
public class Gallery {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue
    @Column(name = "GALLERY_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;

    @Column(name = "GALLERY_NAME")
    private String galleryName;

    @OneToMany(cascade = CascadeType.ALL,
            targetEntity = Photo.class,
            fetch = FetchType.EAGER,
            mappedBy = "gallery")
    private List<Photo> photoList = new ArrayList<>();

    public Gallery(User user, String galleryName) {
        this.user = user;
        this.galleryName = galleryName;
    }
}
