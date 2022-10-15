package com.br.cadastro_pessoa.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    //injeção de dependência do PessoaService:
    @Autowired 
    private PessoaService service;
    //injeção de dependência do ModelMapper:
    @Autowired
    private ModelMapper mapper;
    
    @PostMapping
    @ApiOperation("Criar cadastro")
    public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO pessoaDTO){
        PessoaModel pessoaModel = service.create(pessoaDTO);
        URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(pessoaModel.getId())
        .toUri();
        return ResponseEntity.created(uri).build();
    } 

    @GetMapping
    @ApiOperation("Listar todas as pessoas")
    public ResponseEntity<List<PessoaDTO>> findAll(){
        return ResponseEntity.ok()
        .body(service.findAll()
        .stream().map(objetos -> mapper.map(objetos, PessoaDTO.class))
        .collect(Collectors.toList()));
    }

    

    

}
