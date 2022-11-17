package com.senai.ProjetoFinalSpingboot.service;

import com.senai.ProjetoFinalSpingboot.model.Aluno;
import com.senai.ProjetoFinalSpingboot.model.Curso;
import com.senai.ProjetoFinalSpingboot.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> findAll(){
        List<Aluno> aluno = alunoRepository.findAll();
        return aluno;
    }

    @Transactional

public Aluno cadrastrarAluno(Aluno aluno){

        Curso curso1 = new Curso(1);
        Curso curso2 = new Curso(2);
        Curso curso3 = new Curso(3);

        if (aluno.getNota() >= 70.0){
            aluno.setCurso(curso1);
        } else if (aluno.getNota() >=50.0){
            aluno.setCurso(curso2);
        }else{
            aluno.setCurso(curso3);
        }
        return alunoRepository.save(aluno);
    }

    public Optional<Aluno> findAll(Integer id){
        return alunoRepository.findById(id);
    }

    @Transactional
    public void removerAluno(Integer id){
        alunoRepository.deleteAllById(Collections.singleton(id));
    }
}
