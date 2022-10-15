package com.br.cadastro_pessoa.interfaces;

import java.util.List;

import com.br.cadastro_pessoa.dtos.PessoaDTO;
import com.br.cadastro_pessoa.models.PessoaModel;

public interface PessoaServiceInterface {
    
    List<PessoaModel> findAll();
    PessoaModel findById(Long id);
    PessoaModel create(PessoaDTO pessoaDTO);
    PessoaModel update(PessoaDTO pessoaDTO);
    void deleteById(Long id);

}
