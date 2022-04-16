package com.algaworks.algafood.cidade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.entity.Cidade;

@Component
public class CidadeRepository {
    
    @PersistenceContext
    private EntityManager enitEntityManager;
    
    public List<Cidade> listar() {
        return this.enitEntityManager.createQuery("from Cidade", Cidade.class).getResultList();
    }
    
    public Cidade getPorCodigo(final Long codigo) {
        
        final Cidade cidade = this.enitEntityManager.find(Cidade.class, codigo);
        
        if (cidade != null) {
            this.enitEntityManager.detach(cidade);
            return cidade;
        }
        return null;
    }
    
}
