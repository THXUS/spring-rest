package com.algaworks.algafood.di.modelo;

public class Cliente {
    
    private String nome;
    
    private String telefone;
    
    private String email;
    
    private boolean isAtivo = false;
    
    public Cliente(final String nome, final String telefone, final String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(final String nome) {
        this.nome = nome;
    }
    
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(final String telefone) {
        this.telefone = telefone;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    public boolean isAtivo() {
        return this.isAtivo;
    }
    
    public void ativar() {
        this.isAtivo = true;
    }
    
}
