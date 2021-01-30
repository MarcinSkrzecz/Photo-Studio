package com.marcin.photo_studio.domain.gallery;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GalleryRepository extends CrudRepository<Gallery, Long> {
    @Override
    List<Gallery> findAll();

    @Override
    Optional<Gallery> findById(Long id);

    @Override
    Gallery save(Gallery gallery);

    @Override
    void deleteById(Long id);
}