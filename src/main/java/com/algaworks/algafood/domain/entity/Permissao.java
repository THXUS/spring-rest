package com.algaworks.algafood.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permissao")
public class Permissao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pm_codigo")
    private Long codigo;
    
    @Column(name = "pm_nome", nullable = false, length = 30)
    private String nome;
    
    @Column(name = "pm_descricao")
    private String descricao;
    
    public Long getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(final Long codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(final String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }
    
}
