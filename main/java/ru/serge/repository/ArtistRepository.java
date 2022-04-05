package ru.serge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.serge.entity.Artist;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Integer> {
}
