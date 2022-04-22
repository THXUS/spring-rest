package com.algaworks.algafood.cidade;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.entity.Cidade;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontrada;

@Service
public class CidadeService {
    
    @Autowired
    private CidadeRepository cidadeRepository;
    
    public List<Cidade> listar() {
        return this.cidadeRepository.listar();
    }
    
    public Cidade getPorCodigo(final Long codigo) {
        
        return this.cidadeRepository.getPorCodigo(codigo);
    }
    
    @Transactional
    public void excluir(final Long codigo) {
        final Optional<Cidade> entidade = Optional.ofNullable(this.cidadeRepository.getPorCodigo(codigo));
        
        if (entidade.isEmpty()) {
            throw new EntidadeNaoEncontrada(String.format("Cidade %d não foi encontrada!", codigo));
        }
        
        this.cidadeRepository.excluir(entidade.get());
        
    }
    
    @Transactional
    public Cidade inserir(final Cidade entidade) {
        this.cidadeRepository.inserir(entidade);
        return entidade;
    }
    
}
