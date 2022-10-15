package com.br.cadastro_pessoa.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.cadastro_pessoa.dtos.PessoaDTO;
import com.br.cadastro_pessoa.models.PessoaModel;
import com.br.cadastro_pessoa.services.PessoaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/pessoa")
@Api(tags = "API Controller")
public class PessoaController {

    private static final String ID = "/{id}";

    //injeção de dependência do PessoaService:
    @Autowired 
    private PessoaService service;
    //injeção de dependência do ModelMapper:
    @Autowired
    private ModelMapper mapper;
    
    //Método para criação de pessoa 
    @PostMapping
    @ApiOperation("Criar cadastro")
    public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO pessoaDTO){
        PessoaModel pessoaModel = service.create(pessoaDTO);
        URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path(ID)
        .buildAndExpand(pessoaModel.getId())
        .toUri();
        return ResponseEntity.created(uri).build();
    } 

    //Método para buscar todas as pessoas no banco de dados:
    @GetMapping
    @ApiOperation("Listar todas as pessoas")
    public ResponseEntity<List<PessoaDTO>> findAll(){
        return ResponseEntity.ok()
        .body(service.findAll()
        .stream().map(objetos -> mapper.map(objetos, PessoaDTO.class))
        .collect(Collectors.toList()));
    }

    //Método para buscar pessoa por Id:
    @GetMapping(ID)
    @ApiOperation("Busca por Id")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(mapper.map(service.findById(id), PessoaDTO.class));
    }

    //Método para atualizar cadastro
    @PutMapping(ID)
    @ApiOperation("Atualizar")
    public ResponseEntity<PessoaDTO> update(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO){
        pessoaDTO.setId(id);
        return ResponseEntity.ok().body(mapper.map(service.update(pessoaDTO), PessoaDTO.class));
    }

    //Método para deletar cadastro
    @DeleteMapping(ID)
    @ApiOperation("Deletar")
    public ResponseEntity<PessoaDTO> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    

    

}
