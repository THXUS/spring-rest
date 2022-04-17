package com.algaworks.algafood.estado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.entity.Estado;

@Component
public class EstadoRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Estado> listar() {
        return this.entityManager.createQuery("from Estado", Estado.class).getResultList();
    }
    
    @Transactional
    public void excluir(final Estado entidade) {
        
        this.entityManager.remove(this.entityManager.contains(entidade) ? entidade : this.entityManager.merge(entidade));
        
    }
    
    public Estado getPorCodigo(final Long codigo) {
        final Estado entidade = this.entityManager.find(Estado.class, codigo);
        
        if (entidade != null) {
            this.entityManager.detach(entidade);
            return entidade;
        }
        
        throw new EmptyResultDataAccessException(1);
        
    }
    
}
