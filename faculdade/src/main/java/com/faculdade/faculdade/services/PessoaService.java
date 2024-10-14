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

    public Pessoa findById(Integer id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById((id));
        return pessoa.orElse(null);
    }

    public Pessoa gravarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void deletar(Integer id) {
        pessoaRepository.deleteById(id);
    }

    public Pessoa updatePessoa(Integer id, Pessoa pessoa) {
        Pessoa alterado = findById(id);
        if(alterado != null) {
            alterado.setNome(pessoa.getNome());
            alterado.setCpf(pessoa.getCpf());

        }
        return pessoaRepository.save(alterado);
    }
}
