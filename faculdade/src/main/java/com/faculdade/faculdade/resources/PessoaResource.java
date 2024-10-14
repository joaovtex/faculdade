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

    @GetMapping(value = "/{id}")
    public ResponseEntity <Pessoa> findById(@PathVariable Integer id) {
        Pessoa pessoa = pessoaService.findById(id);
        return ResponseEntity.ok().body(pessoa);
    }

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
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{ra}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa);
    }
}
