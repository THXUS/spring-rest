package com.algaworks.algafood.cozinha;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.entity.Cozinha;

@Component
public class CozinhaRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Cozinha> listar() {
        return this.entityManager.createQuery("from Cozinha", Cozinha.class).getResultList();
    }
}
