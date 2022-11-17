package com.senai.ProjetoFinalSpingboot.controller;


import com.senai.ProjetoFinalSpingboot.model.Aluno;
import com.senai.ProjetoFinalSpingboot.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>>getAllAluno(){
       return ResponseEntity.ok().body(alunoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> insertAluno(@RequestBody Aluno aluno){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.cadrastrarAluno(aluno));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getAluno(@PathVariable(value = "id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.findAll(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteAluno(@PathVariable Integer id ){
        alunoService.removerAluno(id);
        return ResponseEntity.status(HttpStatus.OK).body("Aluno removido do banco de dados!");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateAluno (@PathVariable(value = "id") Integer id, @RequestBody Aluno aluno){
        Optional<Aluno> dadosAluno = alunoService.findAll(id);
        Aluno alterarAluno = dadosAluno.get();
        alterarAluno.setNome(aluno.getNome());
        alterarAluno.setIdade(aluno.getIdade());
        alterarAluno.setSexo(aluno.getSexo());
        alterarAluno.setAltura(aluno.getAltura());
        alterarAluno.setNota(aluno.getNota());

        return ResponseEntity.status(HttpStatus.OK).body(alunoService.cadrastrarAluno(alterarAluno));
    }


}
