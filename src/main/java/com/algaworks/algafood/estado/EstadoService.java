package com.algaworks.algafood.estado;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.entity.Estado;
import com.algaworks.algafood.domain.exception.EntidadeEmUso;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontrada;
import com.algaworks.algafood.domain.exception.SingletonNaoEncontrado;

@Service
public class EstadoService {
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    public List<Estado> listar() {
        return this.estadoRepository.listar();
    }
    
    public Estado getPorCodigo(final Long codigo) {
        final Estado entidade = this.estadoRepository.getPorCodigo(codigo);
        
        if (Objects.nonNull(entidade)) {
            return entidade;
        }
        
        throw new SingletonNaoEncontrado(String.format("Estado %d não foi encontrado!", codigo));
    }
    
    public void excluir(final Long codigo) {
        
        try {
            final Estado entidade = this.estadoRepository.getPorCodigo(codigo);
            
            this.estadoRepository.excluir(entidade);
            
        } catch (final DataIntegrityViolationException e) {
            throw new EntidadeEmUso(String.format("Estado %d não pode ser excluído, pois está em uso!", codigo));
        } catch (final EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontrada(String.format("Estado %d não foi encontrado!", codigo));
        }
        
    }
    
}
