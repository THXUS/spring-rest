package com.algaworks.algafood.estado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.entity.Estado;

@RestController
@RequestMapping("/estado")
public class EstadoController {
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    @GetMapping
    public List<Estado> listar() {
        return this.estadoRepository.listar();
    }
}
