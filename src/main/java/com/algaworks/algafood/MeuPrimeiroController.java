package com.algaworks.algafood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.service.AtivacaoClienteService;

@Controller
public class MeuPrimeiroController {
    
    @Autowired
    private AtivacaoClienteService ativacaoClienteService;
    
    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        
        final Cliente joao = new Cliente("Joao", "664614651", "jao@jaoao.com");
        this.ativacaoClienteService.ativar(joao);
        
        return "Hello World";
    }
}
