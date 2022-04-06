package ru.serge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.serge.entity.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
}
