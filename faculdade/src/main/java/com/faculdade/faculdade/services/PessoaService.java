package com.faculdade.faculdade.services;
import com.faculdade.faculdade.entities.Pessoa;
import com.faculdade.faculdade.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return pessoas;
    }

    public Pessoa findByNome(String nome) {
        Optional <Pessoa> pessoa = pessoaRepository.findByNome(nome);
        return  pessoa.orElse(null);
    }


    public Pessoa findByCpf(String cpf) {
        Optional <Pessoa> pessoa = pessoaRepository.findByCpf(cpf);
        return  pessoa.orElse(null);
    }
}
