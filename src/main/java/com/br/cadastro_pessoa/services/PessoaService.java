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

    //injeção de dependência do PessoaService:
    @Autowired
    private PessoaRepository repository;
    //injeção de dependência do ModelMapper:
    @Autowired
    private ModelMapper mapper;

    //Método para criação de pessoa
    @Override
    public PessoaModel create(PessoaDTO pessoaDTO) {
        return repository.save(mapper.map(pessoaDTO, PessoaModel.class));
    }

    //Método para buscar todas as pessoas no banco de dados:
    @Override
    public List<PessoaModel> findAll() {
        return repository.findAll();
    }

    //Método para buscar pessoa por Id:
    @Override
    public PessoaModel findById(Long id) {
        Optional<PessoaModel> pessoaOptional = repository.findById(id);
        return pessoaOptional.orElseThrow(() -> new ObjectNotFoundException("Dados não encontrados, tente outra vez!"));
    }

    //Método para atualizar
    @Override
    public PessoaModel update(PessoaDTO pessoaDTO) {
        return repository.save(mapper.map(pessoaDTO, PessoaModel.class));
    }

    //Método para deletar buscando por Id
    @Override
    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
        
    }
    
}
