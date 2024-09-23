package com.faculdade.faculdade.resources;

import com.faculdade.faculdade.entities.Aluno;
import com.faculdade.faculdade.services.FaculdadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping (value = "/nome/{nome}")
    public Aluno findByNome(@PathVariable String nome) {
        Aluno aluno = faculdadeService.findByNome(nome);
        return ResponseEntity.ok().body(aluno).getBody();
    }

    @PostMapping
    public ResponseEntity<Aluno> gravarAluno(@RequestBody Aluno aluno) {
        aluno = faculdadeService.gravarAluno(aluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{ra}").buildAndExpand(aluno.getRa(ra)).toUri();
        return ResponseEntity.created(uri).body(aluno);
    }

    @DeleteMapping (value = "/{ra}")
    public ResponseEntity<Void> deletar (@PathVariable Integer ra) {
        faculdadeService.deletar(ra);
        return ResponseEntity.noContent().build();
    }

    @PutMapping (value = "/{ra}")
    public ResponseEntity<Aluno> update (@PathVariable Integer ra, @RequestBody Aluno aluno) {
        aluno.getRa(ra);
        aluno = faculdadeService.updateAluno(ra, aluno);
        return ResponseEntity.ok().body(aluno);
    }
}
