package com.senai.ProjetoFinalSpingboot.repository;

import com.senai.ProjetoFinalSpingboot.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
