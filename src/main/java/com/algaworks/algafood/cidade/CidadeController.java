package com.algaworks.algafood.cidade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.entity.Cidade;

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
    
}
