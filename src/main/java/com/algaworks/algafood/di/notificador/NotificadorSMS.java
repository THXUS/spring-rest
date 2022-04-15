package com.algaworks.algafood.di.notificador;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Component
@TipoDoNotificador(NivelUrgencia.URGENTE)
public class NotificadorSMS implements Notificador {
    
    @Override
    public void notificar(final Cliente cliente, final String mensagem) {
        cliente.ativar();
        
        System.out.println("Notificando o cliente " + cliente.getNome() + " via SMS, através do número :" + cliente.getTelefone() + " " + mensagem);
    }
    
}
