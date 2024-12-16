package com.av3poo3.av3poo3.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.av3poo3.av3poo3.model.Professor;
import com.av3poo3.av3poo3.repositories.ProfessorRepository;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public List<Professor> getAllProfessores() {
        return professorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Professor getProfessorById(@PathVariable Long id) {
        return professorRepository.findById(id).get();
    }

    @PostMapping
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        Professor existingProfessor = professorRepository.findById(id).get();
        existingProfessor.setNome(professor.getNome());
        existingProfessor.setEmail(professor.getEmail());
        existingProfessor.setDisciplinaPrincipal(professor.getDisciplinaPrincipal());
        return professorRepository.save(existingProfessor);
    }

    @DeleteMapping("/{id}")
    public String deleteProfessor(@PathVariable Long id) {
        try {
            professorRepository.deleteById(id);
            return "Professor deletado com sucesso!";
        } catch (Exception e) {
            return "Professor não encontrado";
        }
    }
}