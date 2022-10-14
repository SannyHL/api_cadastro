package com.br.cadastro_pessoa.exceptions;

//Classe para a criação de exceção personalizada

public class ObjectNotFoundException extends RuntimeException{
    
    public ObjectNotFoundException(String message) {
        super(message);
    }

}
