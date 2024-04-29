package org.example.springdemo.service;

import org.example.springdemo.entity.Note;
import org.example.springdemo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{
    private final NoteRepository noteRepository;
    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

@Override
public List<Note> listAll(){
    return noteRepository.findAll();
}
@Override
    public  Note add(Note note) {
        return noteRepository.save(note);
    }
    @Override
    public void deleteById(long id){
        Note note = getById(id);
        if (!note.getId().equals(id)) {
            throw new IllegalArgumentException("Note with id " + id + " not found");
        }
        noteRepository.deleteById(id);
    }
    @Override
    public void update(Note note){
        long id = note.getId();
        Note existingNote = getById(id);
        if (existingNote != null) {
            existingNote.setTitle(note.getTitle());
            existingNote.setContent(note.getContent());
        } else {
            throw new IllegalArgumentException("Note with id " + id + " not found");
        }
        noteRepository.save(note);
    }

    @Override
    public Note getById(long id){
        return noteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " not found"));
    }
}
