package com.algaworks.algafood.restaurante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.entity.Restaurante;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {
    
    @Autowired
    private RestauranteRepository cadastroRestaurante;
    
    @GetMapping
    public List<Restaurante> listar() {
        return this.cadastroRestaurante.listar();
    }
    
}
