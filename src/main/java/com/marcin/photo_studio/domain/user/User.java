package com.marcin.photo_studio.domain.user;

import com.marcin.photo_studio.domain.gallery.Gallery;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "User")
public class User {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ISADMIN")
    private Boolean isAdmin = false;

    @OneToMany(cascade = CascadeType.ALL,
            targetEntity = Gallery.class,
            fetch = FetchType.EAGER,
            mappedBy = "user")
    private List<Gallery> galleryList = new ArrayList<>();

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
