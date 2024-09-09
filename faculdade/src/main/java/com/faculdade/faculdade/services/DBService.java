package com.faculdade.faculdade.services;
import com.faculdade.faculdade.entities.Aluno;
import com.faculdade.faculdade.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

@Service
public class DBService {
    @Autowired
            private AlunoRepository alunoRepository;
    @Bean
    public void instanciarDB() throws ParseException {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Aluno aluno1 = new Aluno("Marcos Monteiro", LocalDate.parse("01/08/2022", formato), true);
        Aluno aluno2 = new Aluno("João Teixeira", LocalDate.parse("01/08/2022", formato), true);
        Aluno aluno3 = new Aluno("Raissa Silva", LocalDate.parse("01/08/2022", formato), false);
        Aluno aluno4 = new Aluno("Gustavo da Silva", LocalDate.parse("01/08/2022", formato), true);
        alunoRepository.saveAll(Arrays.asList(aluno1, aluno2, aluno3, aluno4));
    }
}
