package com.algaworks.algafood.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificador.NivelUrgencia;
import com.algaworks.algafood.di.notificador.Notificador;
import com.algaworks.algafood.di.notificador.TipoDoNotificador;

@Component
public class AtivacaoClienteService {
    
    @Autowired
    @TipoDoNotificador(NivelUrgencia.URGENTE)
    private Notificador notificador;
    
    public void ativar(final Cliente cliente) {
        
        cliente.ativar();
        
        this.notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
        
    }
}
