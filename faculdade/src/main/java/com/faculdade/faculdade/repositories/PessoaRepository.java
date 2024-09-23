package com.faculdade.faculdade.repositories;

import com.faculdade.faculdade.entities.Aluno;
import com.faculdade.faculdade.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    Optional<Pessoa> findByNome(String nome);

    Optional<Pessoa> findByCpf(String cpf);
}
