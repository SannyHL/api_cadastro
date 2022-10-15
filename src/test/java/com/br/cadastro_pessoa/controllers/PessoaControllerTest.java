package com.br.cadastro_pessoa.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    void whenDeleteThenReturnSuccess() {
        doNothing().when(service).deleteById(anyLong());

        ResponseEntity<PessoaDTO> response = controller.delete(ID);

        assertNotNull(response);
        assertEquals(ResponseEntity.class, response.getClass());
        verify(service, times(1)).deleteById(anyLong());
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void whenFindAllThenReturnAnListPessoaDTO() {
        when(service.findAll()).thenReturn(List.of(pessoa));
        when(mapper.map(any(), any())).thenReturn(pessoaDTO);

        ResponseEntity<List<PessoaDTO>> response = controller.findAll();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(ArrayList.class, response.getBody().getClass());
        assertEquals(PessoaDTO.class, response.getBody().get(0).getClass());
        assertEquals(1, response.getBody().size());
        assertEquals(ID, response.getBody().get(0).getId());
        assertEquals(NOME, response.getBody().get(0).getNome());
        assertEquals(DATA_NASCIMENTO, response.getBody().get(0).getDataDeNascimento());
        assertEquals(EMAIL, response.getBody().get(0).getEmail());
    }

    @Test
    void whenFindByIdThenReturnSuccess() {
        when(service.findById(anyLong())).thenReturn(pessoa);

        when(mapper.map(any(), any())).thenReturn(pessoaDTO);

        ResponseEntity<PessoaDTO> response = controller.findById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(PessoaDTO.class, response.getBody().getClass());
        assertEquals(ID, response.getBody().getId());
        assertEquals(NOME, response.getBody().getNome());
        assertEquals(DATA_NASCIMENTO, response.getBody().getDataDeNascimento());
        assertEquals(EMAIL, response.getBody().getEmail());

    }

    private void startQuestions(){

        pessoa  = new PessoaModel(ID, NOME, DATA_NASCIMENTO, EMAIL);

        pessoaDTO = new PessoaDTO(ID, NOME, DATA_NASCIMENTO, EMAIL);
    }
}
