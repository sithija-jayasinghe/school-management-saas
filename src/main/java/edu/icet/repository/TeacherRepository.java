package edu.icet.repository;

import edu.icet.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<TeacherEntity,Integer> {
    List<TeacherEntity> findByNameContainingIgnoreCase(String name);
}
