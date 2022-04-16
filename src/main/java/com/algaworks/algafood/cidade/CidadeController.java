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
    private CidadeRepository cidadeRepository;
    
    @GetMapping
    public ResponseEntity<List<Cidade>> listar() {
        final List<Cidade> cidades = this.cidadeRepository.listar();
        
        if (cidades.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(cidades);
        
    }
    
    @GetMapping("/{codigo}")
    public ResponseEntity<Cidade> getPorCodigo(@PathVariable("codigo") final Long codigo) {
        final Cidade cidade = this.cidadeRepository.getPorCodigo(codigo);
        
        if (cidade != null) {
            return ResponseEntity.ok(cidade);
        }
        return ResponseEntity.notFound().build();
        
    }
    
}
