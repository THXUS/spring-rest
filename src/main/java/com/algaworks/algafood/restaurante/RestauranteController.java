package com.algaworks.algafood.restaurante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.entity.Restaurante;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontrada;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {
    
    @Autowired
    private RestauranteService restauranteService;
    
    @GetMapping
    public List<Restaurante> listar() {
        return this.restauranteService.listar();
    }
    
    @GetMapping("/{codigo}")
    public ResponseEntity<?> getPorCodigo(@PathVariable("codigo") final Long codigo) {
        try {
            return ResponseEntity.ok(this.restauranteService.getPorCodigo(codigo));
        } catch (final EntidadeNaoEncontrada e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> inserir(@RequestBody final Restaurante restaurante) {
        
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.restauranteService.inserir(restaurante));
            
        } catch (final EntidadeNaoEncontrada e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
    }
    
}
