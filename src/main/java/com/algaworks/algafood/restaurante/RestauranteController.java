package com.algaworks.algafood.restaurante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.algaworks.algafood.domain.entity.Restaurante;
import com.algaworks.algafood.jpa.CadastroRestaurante;

@Controller
@RequestMapping("/restaurante")
public class RestauranteController {
    
    @Autowired
    private CadastroRestaurante cadastroRestaurante;
    
    @GetMapping
    @ResponseBody
    public List<Restaurante> listar() {
        return this.cadastroRestaurante.listar();
    }
    
}
