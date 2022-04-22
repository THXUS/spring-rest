package com.algaworks.algafood.cidade;

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

import com.algaworks.algafood.domain.entity.Cidade;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontrada;
import com.algaworks.algafood.domain.exception.RegraDeNegocio;
import com.algaworks.algafood.domain.exception.SingletonNaoEncontrado;

@RestController
@RequestMapping("/cidade")
public class CidadeController {
    
    @Autowired
    private CidadeService cidadeService;
    
    @GetMapping
    public ResponseEntity<List<Cidade>> listar() {
        
        return ResponseEntity.ok(this.cidadeService.listar());
        
    }
    
    @GetMapping("/{codigo}")
    public ResponseEntity<Cidade> getPorCodigo(@PathVariable("codigo") final Long codigo) {
        final Cidade cidade = this.cidadeService.getPorCodigo(codigo);
        
        if (cidade != null) {
            return ResponseEntity.ok(cidade);
        }
        return ResponseEntity.noContent().build();
        
    }
    
    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> excluir(@PathVariable("codigo") final Long codigo) {
        try {
            this.cidadeService.excluir(codigo);
            return ResponseEntity.noContent().build();
        } catch (final EntidadeNaoEncontrada e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> inserir(@RequestBody final Cidade cidade) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.cidadeService.inserir(cidade));
        } catch (final EntidadeNaoEncontrada e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (final RegraDeNegocio e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping("/{codigo}")
    public ResponseEntity<?> alterar(@PathVariable("codigo") final Long codigo, @RequestBody final Cidade cidade) {
        
        try {
            return ResponseEntity.ok(this.cidadeService.alterar(codigo, cidade));
        } catch (final SingletonNaoEncontrado e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (final EntidadeNaoEncontrada e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
}
