package com.algaworks.algafood.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.notificador.NivelUrgencia;
import com.algaworks.algafood.di.notificador.Notificador;
import com.algaworks.algafood.di.notificador.TipoDoNotificador;
import com.algaworks.algafood.di.service.ClienteAtivadoEvent;

@Component
public class NotificacaoService {
    
    @Autowired
    @TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
    private Notificador notificador;
    
    @EventListener
    public void ativarCliente(final ClienteAtivadoEvent event) {
        this.notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo!");
    }
    
    // DEVERIA SER EXTRAÍDO EM UMA CLASSE PRÓPRIA
    @EventListener
    public void emitirNotaFiscal(final ClienteAtivadoEvent event) {
        System.out.println("Emitindo nota fiscal para o cliente " + event.getCliente().getNome() + "!");
    }
    
}
