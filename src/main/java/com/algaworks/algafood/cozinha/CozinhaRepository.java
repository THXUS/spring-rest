package com.algaworks.algafood.cozinha;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
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
    
    public Cozinha getPorCodigo(final Long codigo, final boolean detached) {
        if (detached) {
            final Cozinha entidade = this.entityManager.find(Cozinha.class, codigo, LockModeType.NONE);
            if (entidade != null) {
                this.entityManager.detach(entidade);
            }
            return entidade;
        } else {
            return this.entityManager.find(Cozinha.class, codigo);
        }
    }
    
    public Cozinha getPorCodigo(final Long codigo) {
        
        return this.getPorCodigo(codigo, true);
        
    }
}
