package com.algaworks.algafood.restaurante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.cozinha.CozinhaRepository;
import com.algaworks.algafood.domain.entity.Cozinha;
import com.algaworks.algafood.domain.entity.Restaurante;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontrada;

@Service
public class RestauranteService {
    
    @Autowired
    private RestauranteRepository restauranteRepository;
    
    @Autowired
    private CozinhaRepository cozinhaRepository;
    
    public List<Restaurante> listar() {
        return this.restauranteRepository.listar();
    }
    
    public Restaurante getPorCodigo(final Long codigo) {
        
        try {
            return this.restauranteRepository.getPorCodigo(codigo);
            
        } catch (final EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontrada(String.format("Estado %d não foi encontrado!", codigo));
        }
    }
    
    @Transactional
    public Restaurante inserir(final Restaurante entidade) {
        
        try {
            
            final Cozinha cozinha = this.cozinhaRepository.getPorCodigo(entidade.getCozinha().getCodigo());
            entidade.setCozinha(cozinha);
            
            this.restauranteRepository.inserir(entidade);
            return entidade;
            
        } catch (final EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontrada(String.format("A Cozinha %d, não foi encontrada!", entidade.getCozinha().getCodigo()));
            // TODO: handle exception
        }
        
    }
    
}
