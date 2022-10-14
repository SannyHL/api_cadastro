package com.br.cadastro_pessoa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cadastro_pessoa.models.PessoaModel;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long>{
    
}
