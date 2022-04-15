package com.algaworks.algafood.di.notificador;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Component
public class NotificadorEmail implements Notificador {
    
    @Override
    public void notificar(final Cliente cliente, final String mensagem) {
        System.out.println("Notificando " + cliente.getNome() + " através do e-mail: " + cliente.getEmail() + " " + mensagem);
        
    }
    
}
