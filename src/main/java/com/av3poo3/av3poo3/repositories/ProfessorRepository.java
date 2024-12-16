package com.av3poo3.av3poo3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.av3poo3.av3poo3.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
    
}
