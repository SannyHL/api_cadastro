package com.br.cadastro_pessoa.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {

    //Atributos que serão mostrados na exceção

    private LocalDateTime timeStamp;
    private Integer status;
    private String error;
    private String path;
}
