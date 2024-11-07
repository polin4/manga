package org.example.manga.repository;

import org.example.manga.entity.FolderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FolderRepository extends CrudRepository<FolderEntity, Long> {
    List<FolderEntity> findByUser_UserID(Long userId);
}
