package com.br.cadastro_pessoa.services;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

//Classe para a criação de Bean do Model Mapper.
@Service
public class ModelMapperService {

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
