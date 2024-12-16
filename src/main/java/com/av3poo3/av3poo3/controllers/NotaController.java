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

import com.av3poo3.av3poo3.repositories.NotaRepository;
import com.av3poo3.av3poo3.model.Nota;

@RestController
@RequestMapping("/notas")
public class NotaController {
    @Autowired
    private NotaRepository notaRepository;

    @GetMapping
    public List<Nota> getAllNotas() {
        return notaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Nota getNotaById(@PathVariable Long id) {
        return notaRepository.findById(id).get();
    }

    @PostMapping
    public Nota createNota(@RequestBody Nota nota) {
        return notaRepository.save(nota);
    }

    @PutMapping("/{id}")
    public Nota updateNota(@PathVariable Long id, @RequestBody Nota nota) {
        Nota existingNota = notaRepository.findById(id).get();
        existingNota.setAluno(nota.getAluno());
        existingNota.setDisciplina(nota.getDisciplina());
        existingNota.setValor(nota.getValor());
        existingNota.setDataAvaliacao(nota.getDataAvaliacao());
        return notaRepository.save(existingNota);
    }

    @DeleteMapping("/{id}")
    public String deleteNota(@PathVariable Long id) {
        try {
            notaRepository.deleteById(id);
            return "Nota deletada com sucesso!";
        } catch (Exception e) {
            return "Nota não encontrada";
        }
    }
}


