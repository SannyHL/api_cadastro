package com.br.cadastro_pessoa.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

@SpringBootTest
public class ResourceExceptionHandlerTest {

    @InjectMocks
    private ResourceExceptionHandler exception;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenObjectNotFoundThenReturnAResponseEntity() {
        ResponseEntity<StandardError> response = exception.objectNotFound(new ObjectNotFoundException("Dados não encontrados, tente outra vez!"), new MockHttpServletRequest());

        StandardError responseBody = response.getBody();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass()); 
        assertEquals(StandardError.class, responseBody.getClass());
        assertEquals("Dados não encontrados, tente outra vez!", responseBody.getError());
        assertEquals(404, responseBody.getStatus());
        assertNotEquals("/user/2", responseBody.getPath());
        assertNotEquals(LocalDateTime.now(), responseBody.getTimeStamp());
    }
}
