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

import com.av3poo3.av3poo3.model.Aluno;
import com.av3poo3.av3poo3.repositories.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoRepository AlunoRepository;

    @GetMapping
    public List<Aluno> getAllAlunos(){
        return AlunoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Aluno getAlunoById(@PathVariable Long id){
        return AlunoRepository.findById(id).get();
    }

    @PostMapping
    public Aluno createAluno(@RequestBody Aluno aluno){
        return AlunoRepository.save(aluno);
    }

    @PutMapping("/{id}")
    public Aluno updateAluno (@PathVariable Long id, @RequestBody Aluno aluno){
        Aluno existingAluno = AlunoRepository.findById(id).get();
        existingAluno.setNome(Aluno.getNome());
        return AlunoRepository.save(existingAluno);        
    }

    @DeleteMapping("/{id}")
    public String deleteAluno(@PathVariable Long id){
        try{
            AlunoRepository.deleteById(id);
            return "Aluno deletado com sucesso!";
        }
        catch(Exception e){
            return "Aluno não encontrado";
        }
    }
}
