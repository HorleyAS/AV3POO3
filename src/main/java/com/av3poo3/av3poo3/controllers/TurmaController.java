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

import com.av3poo3.av3poo3.model.Turma;
import com.av3poo3.av3poo3.repositories.TurmaRepository;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
    @Autowired
    private TurmaRepository turmaRepository;

    @GetMapping
    public List<Turma> getAllTurmas() {
        return turmaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Turma getTurmaById(@PathVariable Long id) {
        return turmaRepository.findById(id).get();
    }

    @PostMapping
    public Turma createTurma(@RequestBody Turma turma) {
        return turmaRepository.save(turma);
    }

    @PutMapping("/{id}")
    public Turma updateTurma(@PathVariable Long id, @RequestBody Turma turma) {
        Turma existingTurma = turmaRepository.findById(id).get();
        existingTurma.setNome(turma.getNome());
        existingTurma.setAno(turma.getAno());
        existingTurma.setAlunos(turma.getAlunos());
        existingTurma.setDisciplinas(turma.getDisciplinas());
        return turmaRepository.save(existingTurma);
    }

    @DeleteMapping("/{id}")
    public String deleteTurma(@PathVariable Long id) {
        try {
            turmaRepository.deleteById(id);
            return "Turma deletada com sucesso!";
        } catch (Exception e) {
            return "Turma não encontrada";
        }
    }
}
