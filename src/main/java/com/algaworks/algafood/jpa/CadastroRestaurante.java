package com.algaworks.algafood.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.entity.Restaurante;

@Component
public class CadastroRestaurante {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Restaurante> listar() {
        return this.entityManager.createQuery("from Restaurante", Restaurante.class).getResultList();
    }
}
