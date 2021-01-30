package com.marcin.photo_studio.domain.photo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PhotoRepository extends CrudRepository<Photo, Long> {
    @Override
    List<Photo> findAll();

    @Override
    Optional<Photo> findById(Long id);

    @Override
    Photo save(Photo photo);

    @Override
    void deleteById(Long id);
}
