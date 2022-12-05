package com.graphql.solicitacoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.solicitacoes.entity.Exame;

@Repository
public interface ExameRepository extends JpaRepository<Exame,Long> {
    
}
