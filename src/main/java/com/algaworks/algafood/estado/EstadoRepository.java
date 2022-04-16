package com.algaworks.algafood.estado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.entity.Estado;

@Component
public class EstadoRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Estado> listar() {
        return this.entityManager.createQuery("from Estado", Estado.class).getResultList();
    }
    
}
