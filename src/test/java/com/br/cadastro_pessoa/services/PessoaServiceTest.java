package com.br.cadastro_pessoa.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.cadastro_pessoa.dtos.PessoaDTO;
import com.br.cadastro_pessoa.exceptions.ObjectNotFoundException;
import com.br.cadastro_pessoa.models.PessoaModel;
import com.br.cadastro_pessoa.repositories.PessoaRepository;

@SpringBootTest
public class PessoaServiceTest {

    private static final Long ID = 1L;
    private static final String NOME = "Fernada Abreu";
    private static final LocalDate DATA_NASCIMENTO = LocalDate.of(1995, 04, 06);
    private static final String EMAIL = "fernada@gmail.com";

    @InjectMocks
    private PessoaService service;

    @Mock
    private PessoaRepository repository;
    @Mock
    private ModelMapper mapper;

    private PessoaModel pessoa = new PessoaModel();
    private Optional<PessoaModel> pessoaOptional;
    private PessoaDTO pessoaDTO = new PessoaDTO();

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        startQuestions();
    }

    @Test
    void whenCreateThenReturnSucess() {
        when(repository.save(any())).thenReturn(pessoa);
        PessoaModel response = service.create(pessoaDTO);
        
        assertNotNull(response);
        assertEquals(ID, response.getId());
        assertEquals(NOME, response.getNome());
        assertEquals(DATA_NASCIMENTO, response.getDataDeNascimento());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(PessoaModel.class, response.getClass());
    }

    @Test
    void whenDeleteByIdWhithSuces() {
        when(repository.findById(anyLong())).thenReturn(pessoaOptional);

        service.deleteById(ID);

        verify(repository, times(1)).deleteById(anyLong());
    }

    @Test
    void deleteWithObjectNotFoundException() {
        when(repository.findById(anyLong())).thenThrow(new ObjectNotFoundException("Dados n??o encontrados, tente outra vez!"));
        
        try{
            service.deleteById(ID);
        } catch (Exception e){
            assertEquals(ObjectNotFoundException.class, e.getClass());
            assertEquals("Dados n??o encontrados, tente outra vez!", e.getMessage());
        }
    }

    @Test
    void whenFindAllReturnAnListOfPessoas() {
        when(repository.findAll()).thenReturn(List.of(pessoa));

        List<PessoaModel> response = service.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(ID, response.get(0).getId());
        assertEquals(NOME, response.get(0).getNome());
        assertEquals(DATA_NASCIMENTO, response.get(0).getDataDeNascimento());
        assertEquals(EMAIL, response.get(0).getEmail());
        assertEquals(PessoaModel.class, response.get(0).getClass()); 
    }

    @Test
    void whenFindByIdThenReturnAnPessoa() {
        when(repository.findById(anyLong())).thenReturn(pessoaOptional);

        PessoaModel response = service.findById(ID);
        
        assertNotNull(response);
        assertEquals(ID, response.getId());
        assertEquals(NOME, response.getNome());
        assertEquals(DATA_NASCIMENTO, response.getDataDeNascimento());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(PessoaModel.class, response.getClass());
    }

    @Test
    void whenFindByIdThenReturnObjectNotFoundException() {
        when(repository.findById(anyLong())).thenThrow(new ObjectNotFoundException("Dados n??o encontrados, tente outra vez!"));

        try{
            service.findById(ID);
        } catch (Exception e){
            assertEquals(ObjectNotFoundException.class, e.getClass());
            assertEquals("Dados n??o encontrados, tente outra vez!", e.getMessage());
        }
    }

    @Test
    void whenUpdateThenReturnSucess() {
        when(repository.save(any())).thenReturn(pessoa);

        PessoaModel response = service.update(pessoaDTO);

        assertNotNull(response);
        assertEquals(ID, response.getId());
        assertEquals(NOME, response.getNome());
        assertEquals(DATA_NASCIMENTO, response.getDataDeNascimento());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(PessoaModel.class, response.getClass());
    }

    private void startQuestions(){

        pessoa  = new PessoaModel(ID, NOME, DATA_NASCIMENTO, EMAIL);

        pessoaOptional = Optional.of(new PessoaModel(ID, NOME, DATA_NASCIMENTO, EMAIL));

        pessoaDTO = new PessoaDTO(ID, NOME, DATA_NASCIMENTO, EMAIL);
    }
}
