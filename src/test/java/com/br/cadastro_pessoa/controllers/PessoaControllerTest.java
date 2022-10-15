package com.br.cadastro_pessoa.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.br.cadastro_pessoa.dtos.PessoaDTO;
import com.br.cadastro_pessoa.models.PessoaModel;
import com.br.cadastro_pessoa.services.PessoaService;

@SpringBootTest
public class PessoaControllerTest {

    private static final Long ID = 1L;
    private static final String NOME = "Fernada Abreu";
    private static final LocalDate DATA_NASCIMENTO = LocalDate.of(1995, 04, 06);
    private static final String EMAIL = "fernada@gmail.com";

    @InjectMocks
    private PessoaController controller;

    @Mock
    private PessoaService service;
    @Mock
    private ModelMapper mapper;

    private PessoaModel pessoa = new PessoaModel();
    private PessoaDTO pessoaDTO = new PessoaDTO();

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        startQuestions();
    }

    @Test
    void whenCreateThenReturnCreated() {
        when(service.create(any())).thenReturn(pessoa);

        ResponseEntity<PessoaDTO> response = controller.create(pessoaDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response);
        assertNull(response.getBody());
        assertNotNull(response.getHeaders().get("Location"));
        assertEquals(ResponseEntity.class, response.getClass());
    }


    private void startQuestions(){

        pessoa  = new PessoaModel(ID, NOME, DATA_NASCIMENTO, EMAIL);

        pessoaDTO = new PessoaDTO(ID, NOME, DATA_NASCIMENTO, EMAIL);
    }
}
