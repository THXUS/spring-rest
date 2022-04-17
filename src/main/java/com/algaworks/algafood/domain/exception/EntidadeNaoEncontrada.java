package com.algaworks.algafood.domain.exception;

public class EntidadeNaoEncontrada extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public EntidadeNaoEncontrada(final String mensagem) {
        super(mensagem);
    }
    
}
