package com.algaworks.algafood.restaurante;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.entity.Restaurante;

@Component
public class RestauranteRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Restaurante> listar() {
        return this.entityManager.createQuery("from Restaurante", Restaurante.class).getResultList();
    }
    
    public Restaurante getPorCodigo(final Long codigo) {
        final Restaurante entidade = this.entityManager.find(Restaurante.class, codigo);
        
        if (entidade != null) {
            this.entityManager.detach(entidade);
            return entidade;
        }
        
       return null;
    }
    
    public void inserir(final Restaurante entidade) {
        
        this.entityManager.persist(entidade);
        
    }
    
    public void alterar(final Restaurante entidade) {
        this.entityManager.merge(entidade);
    }
}
