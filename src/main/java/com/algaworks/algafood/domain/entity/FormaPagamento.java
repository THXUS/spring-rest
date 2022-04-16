package com.algaworks.algafood.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "forma_pagamento")
@Entity
public class FormaPagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fp_codigo")
    private Long codigo;
    
    @Column(name = "fp_descricao", nullable = false, length = 30)
    private String descricao;
    
    public Long getId() {
        return this.codigo;
    }
    
    public void setId(final Long id) {
        this.codigo = id;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }
    
}
