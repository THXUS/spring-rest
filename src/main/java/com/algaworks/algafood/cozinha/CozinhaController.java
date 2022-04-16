package com.algaworks.algafood.cozinha;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.entity.Cozinha;

@RestController
@RequestMapping("/cozinha")
public class CozinhaController {
    
    @Autowired
    private CozinhaRepository cadastroCozinha;
    
    @GetMapping
    public List<Cozinha> listar() {
        return this.cadastroCozinha.listar();
    }
}
