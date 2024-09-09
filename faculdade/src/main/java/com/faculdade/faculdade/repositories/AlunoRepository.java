package com.faculdade.faculdade.repositories;

import com.faculdade.faculdade.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    @Query ("SELECT alunos FROM alunos alunos WHERE alunos.ativo=true ORDER BY alunos.nome")
    List<Aluno> listarTodosAbertos();

    @Query("SELECT alunos FROM alunos alunos WHERE alunos.ativo=false ORDER BY alunos.nome")
    List<Aluno> listarTodosFechados();
}
