package com.redswift.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redswift.store.entities.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
