package com.algaworks.algafood.cidade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.entity.Cidade;

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
    
}
