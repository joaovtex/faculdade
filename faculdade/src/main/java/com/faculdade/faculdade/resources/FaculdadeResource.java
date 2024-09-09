package com.faculdade.faculdade.resources;

import com.faculdade.faculdade.entities.Aluno;
import com.faculdade.faculdade.services.FaculdadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/faculdade")
public class FaculdadeResource {
    @Autowired
    private FaculdadeService faculdadeService;

    public FaculdadeResource(FaculdadeService faculdadeService) {
        this.faculdadeService = faculdadeService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <Aluno> findById(@PathVariable Integer id) {
        Aluno aluno = faculdadeService.findById(id);
        return ResponseEntity.ok().body(aluno);
    }

    @GetMapping(value = "/abertos")
    public ResponseEntity <List<Aluno>> listarAbertos() {
        List<Aluno> alunos = faculdadeService.listarTodosAbertos();
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping (value = "/fechados")
    public ResponseEntity <List<Aluno>> listarFechados() {
        List<Aluno> alunos = faculdadeService.listarTodosFechados();
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping
    public List<Aluno> findAll() {
        List<Aluno> aluno = faculdadeService.findAll();
        return aluno;
    }
}
