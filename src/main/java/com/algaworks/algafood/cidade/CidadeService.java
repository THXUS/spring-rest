package com.algaworks.algafood.cidade;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.entity.Cidade;
import com.algaworks.algafood.domain.entity.Estado;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontrada;
import com.algaworks.algafood.domain.exception.RegraDeNegocio;
import com.algaworks.algafood.estado.EstadoRepository;

@Service
public class CidadeService {
    
    @Autowired
    private CidadeRepository cidadeRepository;
    
    @Autowired
    private EstadoRepository estadoRepository;
    
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
        if (Objects.nonNull(entidade.getEstado()) && entidade.getEstado().getCodigo() != null) {
            final Optional<Estado> estado = Optional.ofNullable(this.estadoRepository.getPorCodigo(entidade.getEstado().getCodigo()));
            entidade.setEstado(estado.orElseThrow(() -> new EntidadeNaoEncontrada(String.format("O Estado %d não foi encontrado!", entidade.getEstado().getCodigo()))));
            this.cidadeRepository.inserir(entidade);
            return entidade;
        }
        
        throw new RegraDeNegocio("Estado é um campo Obrigatório");
        
    }
    
}
