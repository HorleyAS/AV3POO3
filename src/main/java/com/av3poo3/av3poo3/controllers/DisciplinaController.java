package com.av3poo3.av3poo3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.av3poo3.av3poo3.model.Disciplina;
import com.av3poo3.av3poo3.repositories.DisciplinaRepository;


@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @GetMapping
    public List<Disciplina> getAllDisciplinas() {
        return disciplinaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Disciplina getDisciplinaById(@PathVariable Long id) {
        return disciplinaRepository.findById(id).get();
    }

    @PostMapping
    public Disciplina createDisciplina(@RequestBody Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    @PutMapping("/{id}")
    public Disciplina updateDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplina) {
        Disciplina existingDisciplina = disciplinaRepository.findById(id).get();
        existingDisciplina.setNome(disciplina.getNome());
        existingDisciplina.setCargaHoraria(disciplina.getCargaHoraria());
        existingDisciplina.setProfessor(disciplina.getProfessor());
        return disciplinaRepository.save(existingDisciplina);
    }

    @DeleteMapping("/{id}")
    public String deleteDisciplina(@PathVariable Long id) {
        try {
            disciplinaRepository.deleteById(id);
            return "Disciplina deletada com sucesso!";
        } catch (Exception e) {
            return "Disciplina não encontrada";
        }
    }
}

