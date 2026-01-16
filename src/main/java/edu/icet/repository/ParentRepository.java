package edu.icet.repository;

import edu.icet.entity.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParentRepository extends JpaRepository<ParentEntity,Integer> {
    List<ParentEntity> findByNameContainingIgnoreCase(String name);
}
