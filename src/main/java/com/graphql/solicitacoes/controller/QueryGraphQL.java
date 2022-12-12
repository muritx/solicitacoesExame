package com.graphql.solicitacoes.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.solicitacoes.entity.Cliente;
import com.graphql.solicitacoes.entity.Exame;
import com.graphql.solicitacoes.entity.Solicitacao;
import com.graphql.solicitacoes.repository.ClienteRepository;
import com.graphql.solicitacoes.repository.ExameRepository;
import com.graphql.solicitacoes.repository.SolicitacaoRepository;

@Component
public class QueryGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteRepository clienteRep;

    @Autowired
    private ExameRepository exameRep;

    @Autowired
    private SolicitacaoRepository solicitacaoRep;

    //********** CRUD Cliente **********//
    public List<Cliente> clientes() {
        return clienteRep.findAll();
    }

    @Transactional
    public Cliente saveCliente(Long cliente_id, String nome, String email, Long telefone) {
        Cliente c = new Cliente();

        c.setCliente_id(cliente_id);
        c.setNome(nome);
        c.setEmail(email);
        c.setTelefone(telefone);

        return clienteRep.save(c);
    }    

    @Transactional
    public Boolean deleteCliente(Long cliente_id) {
        if(clienteRep.findById(cliente_id).isPresent()) {
            clienteRep.deleteById(cliente_id);
            return true;
        }
        return false;
    }
    //**********************************//

    //*********** CRUD Exame ***********//
    public List<Exame> exames() {
        return exameRep.findAll();
    }

    @Transactional
    public Exame saveExame(Long exame_id, String tipo, String nome, double valor) {
        Exame e = new Exame();

        e.setExame_id(exame_id);
        e.setTipo(tipo);
        e.setNome(nome);
        e.setValor(valor);

        return exameRep.save(e);
    }

    @Transactional
    public Boolean deleteExame(Long exame_id) {
        if(exameRep.findById(exame_id).isPresent()) {
            exameRep.deleteById(exame_id);
            return true;
        }
        return false;
    }
    //**********************************//

    //******** CRUD Solicitacao ********//
    public List<Solicitacao> solicitacoes() {
        return solicitacaoRep.findAll();
    }

    @Transactional
    public Solicitacao saveSolicitacao(Long solicitacao_id, String status, String medico, String prestador, Long cliente_id, Long exame_id) {
        Solicitacao s = new Solicitacao();

        s.setSolicitacao_id(solicitacao_id);
        s.setStatus(status);
        s.setMedico(medico);
        s.setPrestador(prestador);

        s.setCliente(new Cliente(cliente_id));
        s.setExame(new Exame(exame_id));

        return solicitacaoRep.save(s);
    }

    @Transactional
    public Boolean deleteSolicitacao(Long solicitacao_id) {
        if(solicitacaoRep.findById(solicitacao_id).isPresent()) {
            solicitacaoRep.deleteById(solicitacao_id);
            return true;
        }
        return false;
    }

    public Solicitacao solicitacao(Long solicitacao_id) {
        return solicitacaoRep.findById(solicitacao_id).orElse(null);
    }
    //**********************************//
    
}