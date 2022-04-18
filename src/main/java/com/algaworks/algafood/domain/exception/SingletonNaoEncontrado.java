package com.algaworks.algafood.domain.exception;

public class SingletonNaoEncontrado extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public SingletonNaoEncontrado(final String mensagem) {
        super(mensagem);
    }
    
}
