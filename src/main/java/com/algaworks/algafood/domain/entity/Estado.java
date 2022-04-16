package com.algaworks.algafood.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "es_codigo")
    private Long codigo;
    
    @Column(name = "es_nome", nullable = false, length = 30)
    private String nome;
    
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
    
}
