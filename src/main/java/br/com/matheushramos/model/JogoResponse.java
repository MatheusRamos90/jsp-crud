package br.com.matheushramos.model;

import javax.xml.bind.annotation.XmlElement;

public class JogoResponse {
    private int id;
    private String nome;
    
    @XmlElement
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @XmlElement
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
} 