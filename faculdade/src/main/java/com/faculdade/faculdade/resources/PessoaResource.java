package com.faculdade.faculdade.resources;
import com.faculdade.faculdade.entities.Pessoa;
import com.faculdade.faculdade.repositories.PessoaRepository;
import com.faculdade.faculdade.services.FaculdadeService;
import com.faculdade.faculdade.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
