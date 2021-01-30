package com.marcin.photo_studio.service;

import com.marcin.photo_studio.domain.photo.Photo;
import com.marcin.photo_studio.domain.photo.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository repository;

    public List<Photo> getAllPhotos() {
        return repository.findAll();
    }

    public Photo getPhoto(final Long photoId) {
        if (repository.findById(photoId).isPresent()) {
            return repository.findById(photoId).get();
        } else throw new IllegalArgumentException("Photo not found");
    }

    public void createPhoto(final Photo photo) {
        repository.save(photo);
    }

    public Photo updatePhotoName(Long photoId, String newPhotoName) {
        Optional<Photo> dbRecord = repository.findById(photoId);

        if (dbRecord.isPresent()) {
            Photo photoToUpdate = dbRecord.get();

            photoToUpdate.setPhotoName(newPhotoName);

            repository.save(photoToUpdate);
            return photoToUpdate;
        } else throw new IllegalArgumentException("Photo not found");
    }

    public void deletePhoto(long photoId) {
        repository.deleteById(photoId);
    }
}
