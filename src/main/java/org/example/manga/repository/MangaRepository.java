package org.example.manga.repository;

import org.example.manga.entity.MangaEntity;
import org.springframework.data.repository.CrudRepository;

public interface MangaRepository extends CrudRepository<MangaEntity, Long> {
}
