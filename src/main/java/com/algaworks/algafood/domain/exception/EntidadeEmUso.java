package com.algaworks.algafood.domain.exception;

public class EntidadeEmUso extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public EntidadeEmUso(final String mensagem) {
        super(mensagem);
    }
}
