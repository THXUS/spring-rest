package com.algaworks.algafood.cozinha;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.algaworks.algafood.domain.entity.Cozinha;
import com.algaworks.algafood.jpa.CadastroCozinha;

@Controller
@RequestMapping("/cozinha")
public class CozinhaController {
    
    @Autowired
    private CadastroCozinha cadastroCozinha;
    
    @GetMapping
    @ResponseBody
    public List<Cozinha> buscarCozinha() {
        return this.cadastroCozinha.listar();
    }
}
