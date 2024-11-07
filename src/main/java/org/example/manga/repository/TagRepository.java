package org.example.manga.repository;

import org.example.manga.entity.TagEntity;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<TagEntity, String> {
}
