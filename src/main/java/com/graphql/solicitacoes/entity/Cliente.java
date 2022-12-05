package com.graphql.solicitacoes.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;
    private String nome;
    private String email;
    private Long telefone;

    public Cliente(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

}
