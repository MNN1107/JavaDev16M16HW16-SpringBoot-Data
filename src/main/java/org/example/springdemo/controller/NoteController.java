package org.example.springdemo.controller;

import org.example.springdemo.entity.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {
    private List<Note> notes = new ArrayList<>();

    @GetMapping("/list")
    public String listNote(Model model) {
        model.addAttribute("notes", notes);
        return "note/list";
    }

    @PostMapping("/delete")
    public String deleteNoteById(@RequestParam("id") long id) {
        notes.removeIf(note -> note.getId() == id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editNotePage(@RequestParam("id") long id, Model model) {
        Note note = notes.stream()
                .filter(n -> n.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " not found"));
        model.addAttribute("note", note);
        return "note/edit";
    }

    @PostMapping("/edit")
    public String editNote(@ModelAttribute Note note) {
        notes.stream()
                .filter(n -> n.getId() == note.getId())
                .findFirst()
                .ifPresent(n -> {
                    n.setTitle(note.getTitle());
                    n.setContent(note.getContent());
                });
        return "redirect:/note/list";
    }
}
