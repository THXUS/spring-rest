package com.algaworks.algafood.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "restaurante")
public class Restaurante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "res_codigo")
    private Long codigo;
    
    @Column(name = "res_nome", length = 30)
    private String nome;
    
    @Column(name = "res_taxafrete")
    private BigDecimal taxaFrete;
    
    @ManyToOne
    @JoinColumn(name = "res_cozinha")
    private Cozinha cozinha;
    
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
    
    public BigDecimal getTaxaFrete() {
        return this.taxaFrete;
    }
    
    public void setTaxaFrete(final BigDecimal taxaFrete) {
        this.taxaFrete = taxaFrete;
    }
    
    public Cozinha getCozinha() {
        return this.cozinha;
    }
    
    public void setCozinha(final Cozinha cozinha) {
        this.cozinha = cozinha;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.codigo == null) ? 0 : this.codigo.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Restaurante other = (Restaurante) obj;
        if (this.codigo == null) {
            if (other.codigo != null) {
                return false;
            }
        } else if (!this.codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }
    
}
