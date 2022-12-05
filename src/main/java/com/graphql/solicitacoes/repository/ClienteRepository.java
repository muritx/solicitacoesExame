package com.graphql.solicitacoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.solicitacoes.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    
}
