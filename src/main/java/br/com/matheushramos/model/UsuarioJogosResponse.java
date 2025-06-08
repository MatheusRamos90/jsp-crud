package br.com.matheushramos.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class UsuarioJogosResponse {
    private int id;
    private List<JogoResponse> jogos;
    
    @XmlElement
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @XmlElementWrapper(name = "jogos")
    @XmlElement(name = "jogo")
    public List<JogoResponse> getJogos() {
        return jogos;
    }
    
    public void setJogos(List<JogoResponse> jogos) {
        this.jogos = jogos;
    }
} 