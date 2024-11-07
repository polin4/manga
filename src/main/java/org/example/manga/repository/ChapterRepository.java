package org.example.manga.repository;

import org.example.manga.entity.ChapterEntity;
import org.springframework.data.repository.CrudRepository;

public interface ChapterRepository extends CrudRepository<ChapterEntity, Long> {
}
