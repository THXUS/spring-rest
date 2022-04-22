package com.algaworks.algafood.estado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.entity.Estado;
import com.algaworks.algafood.domain.exception.EntidadeEmUso;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontrada;
import com.algaworks.algafood.domain.exception.SingletonNaoEncontrado;

@RestController
@RequestMapping("/estado")
public class EstadoController {
    
    @Autowired
    private EstadoService estadoService;
    
    @GetMapping
    public List<Estado> listar() {
        return this.estadoService.listar();
    }
    
    @GetMapping("/{codigo}")
    public ResponseEntity<?> getPorCodigo(@PathVariable("codigo") final Long codigo) {
        try {
            return ResponseEntity.ok(this.estadoService.getPorCodigo(codigo));
        } catch (final SingletonNaoEncontrado e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> inserir(@RequestBody final Estado entidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.estadoService.inserir(entidade));
    }
    
    @PutMapping("/{codigo}")
    public ResponseEntity<?> alterar(@PathVariable("codigo") final Long codigo, @RequestBody final Estado entidade) {
        try {
            return ResponseEntity.ok(this.estadoService.alterar(codigo, entidade));
        } catch (final EntidadeNaoEncontrada e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> excluir(@PathVariable("codigo") final Long codigo) {
        
        try {
            this.estadoService.excluir(codigo);
            return ResponseEntity.noContent().build();
            
        } catch (final EntidadeEmUso e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (final EntidadeNaoEncontrada e) {
            return ResponseEntity.notFound().build();
            
        }
    }
}
