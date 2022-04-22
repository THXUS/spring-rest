package com.algaworks.algafood.domain.exception;

public class RegraDeNegocio extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public RegraDeNegocio(final String mensagem) {
        super(mensagem);
    }
    
}
