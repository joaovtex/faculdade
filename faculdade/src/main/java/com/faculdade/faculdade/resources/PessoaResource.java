package com.faculdade.faculdade.resources;
import com.faculdade.faculdade.entities.Aluno;
import com.faculdade.faculdade.entities.Pessoa;
import com.faculdade.faculdade.repositories.PessoaRepository;
import com.faculdade.faculdade.services.FaculdadeService;
import com.faculdade.faculdade.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = pessoaService.findAll();
        return pessoas;
    }

    @GetMapping(value = "/nome/{nome}")
    public Pessoa findByNome(@PathVariable String nome) {
        Pessoa pessoa = pessoaService.findByNome(nome);
        return ResponseEntity.ok().body(pessoa).getBody();
    }

    @GetMapping (value = "/cpf/{cpf}")
    public Pessoa findbyCpf(@PathVariable String cpf) {
        Pessoa pessoa = pessoaService.findByCpf(cpf);
        return ResponseEntity.ok().body(pessoa).getBody();
    }

    @PostMapping
    public ResponseEntity<Pessoa> gravarPessoa(@RequestBody Pessoa pessoa) {
        pessoa = pessoaService.gravarPessoa(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa);
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Integer id) {
        pessoaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping (value = "/{id}")
    public ResponseEntity<Pessoa> update (@PathVariable Integer id, @RequestBody Pessoa pessoa) {
        pessoa.setId(id);
        pessoa = pessoaService.updatePessoa(id, pessoa);
        return ResponseEntity.ok().body(pessoa);
    }
}
