package com.algaworks.algafood.restaurante;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.cozinha.CozinhaRepository;
import com.algaworks.algafood.domain.entity.Cozinha;
import com.algaworks.algafood.domain.entity.Restaurante;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontrada;
import com.algaworks.algafood.domain.exception.SingletonNaoEncontrado;

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
        
        final Restaurante entidade = this.restauranteRepository.getPorCodigo(codigo);
        
        if (Objects.nonNull(entidade)) {
            return entidade;
        }
        
        throw new SingletonNaoEncontrado(String.format("Restaurante %d não encontrado", codigo));
        
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
        }
        
    }
    
    @Transactional
    public Restaurante alterar(final Long codigo, final Restaurante restaurante) {
        final Restaurante entidade = this.restauranteRepository.getPorCodigo(codigo);
        
        if (!Objects.nonNull(entidade)) {
            throw new SingletonNaoEncontrado(String.format("O restaurante %d, não foi encontrado!", codigo));
        }
        
        if (Objects.nonNull(restaurante.getCozinha())) {
            final Cozinha cozinha = this.cozinhaRepository.getPorCodigo(restaurante.getCozinha().getCodigo());
            if (Objects.nonNull(cozinha)) {
                restaurante.setCozinha(cozinha);
            }
            throw new EntidadeNaoEncontrada(String.format("A Cozinha %d, não foi encontrada!", restaurante.getCozinha().getCodigo()));
        }
        
        BeanUtils.copyProperties(restaurante, entidade, "codigo");
        
        this.restauranteRepository.alterar(entidade);
        
        return entidade;
        
    }
    
}
