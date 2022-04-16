package com.algaworks.algafood.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
public class Cidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_codigo")
    private Long codigo;
    
    @Column(name = "cd_nome", nullable = false, length = 30)
    private String nome;
    
    @JoinColumn(name = "cd_estado", nullable = false)
    @ManyToOne
    private Estado estado;
    
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
    
    public Estado getEstado() {
        return this.estado;
    }
    
    public void setEstado(final Estado estado) {
        this.estado = estado;
    }
    
}
