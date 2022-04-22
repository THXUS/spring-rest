package com.algaworks.algafood.cidade;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.entity.Cidade;
import com.algaworks.algafood.domain.entity.Estado;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontrada;
import com.algaworks.algafood.domain.exception.RegraDeNegocio;
import com.algaworks.algafood.domain.exception.SingletonNaoEncontrado;
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
    
    @Transactional
    public Cidade alterar(final Long codigo, final Cidade cidade) {
        final Optional<Cidade> entidade = Optional.ofNullable(this.cidadeRepository.getPorCodigo(codigo));
        
        if (Objects.nonNull(cidade.getEstado()) && cidade.getEstado().getCodigo() != null) {
            final Optional<Estado> estado = Optional.ofNullable(this.estadoRepository.getPorCodigo(cidade.getEstado().getCodigo()));
            cidade.setEstado(estado.orElseThrow(() -> new EntidadeNaoEncontrada("Estado não encontrado!")));
            BeanUtils.copyProperties(cidade, entidade.orElseThrow(() -> new SingletonNaoEncontrado("Cidade não encontrada")), "codigo");
        } else {
            BeanUtils.copyProperties(cidade, entidade.orElseThrow(() -> new SingletonNaoEncontrado("Cidade não encontrada")), "codigo", "estado");
        }
        
        this.cidadeRepository.alterar(entidade.get());
        
        return entidade.get();
    }
    
}
