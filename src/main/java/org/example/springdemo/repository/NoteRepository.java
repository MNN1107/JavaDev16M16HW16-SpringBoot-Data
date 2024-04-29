package org.example.springdemo.repository;

import org.example.springdemo.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository <Note, Long>{

}
