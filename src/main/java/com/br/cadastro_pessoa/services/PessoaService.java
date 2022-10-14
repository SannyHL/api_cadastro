package com.br.cadastro_pessoa.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.cadastro_pessoa.dtos.PessoaDTO;
import com.br.cadastro_pessoa.exceptions.ObjectNotFoundException;
import com.br.cadastro_pessoa.interfaces.PessoaServiceInterface;
import com.br.cadastro_pessoa.models.PessoaModel;
import com.br.cadastro_pessoa.repositories.PessoaRepository;

@Service
public class PessoaService implements PessoaServiceInterface{

    @Autowired
    private PessoaRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public PessoaModel create(PessoaDTO pessoaDTO) {
        return repository.save(mapper.map(pessoaDTO, PessoaModel.class));
    }

    @Override
    public List<PessoaModel> findAll() {
        return repository.findAll();
    }

    @Override
    public PessoaModel findById(Long id) {
        Optional<PessoaModel> pessoaOptional = repository.findById(id);
        return pessoaOptional.orElseThrow(() -> new ObjectNotFoundException("Dados não encontrados, tente outra vez!"));
    }
    
}
