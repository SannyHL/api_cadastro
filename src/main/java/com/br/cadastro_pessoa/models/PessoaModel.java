package com.br.cadastro_pessoa.models;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.Email;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pessoa")
public class PessoaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    private String nome;

    private LocalDate dataDeNascimento;

    @Email
    private String email;
}
