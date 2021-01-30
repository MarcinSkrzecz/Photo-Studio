package com.marcin.photo_studio.service;

import com.marcin.photo_studio.domain.gallery.Gallery;
import com.marcin.photo_studio.domain.gallery.GalleryRepository;
import com.marcin.photo_studio.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GalleryService {

    @Autowired
    private GalleryRepository repository;
    @Autowired
    private UserService service;

    public List<Gallery> getAllGalleries() {
        return repository.findAll();
    }

    public Gallery getGallery(final Long galleryId) {
        if (repository.findById(galleryId).isPresent()) {
            return repository.findById(galleryId).get();
        } else throw new IllegalArgumentException("Gallery not found");
    }

    public void createGallery(final Gallery gallery) {
        repository.save(gallery);
    }

    public Gallery updateGalleryName(Long galleryId, String galleryName) {
        Optional<Gallery> dbRecord = repository.findById(galleryId);

        if (dbRecord.isPresent()) {
            Gallery galleryToUpdate = dbRecord.get();

            galleryToUpdate.setGalleryName(galleryName);

            repository.save(galleryToUpdate);
            return galleryToUpdate;
        } else throw new IllegalArgumentException("Gallery not found");
    }

    public void deleteGallery(long galleryId) {
        repository.deleteById(galleryId);
    }
}