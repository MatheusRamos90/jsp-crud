package br.com.matheushramos.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "plataformaJogos")
public class PlataformaJogos {
    private int idConsumo;
    private UsuarioJogosResponse usuario;
    
    @XmlElement(name = "id_consumo")
    public int getIdConsumo() {
        return idConsumo;
    }
    
    public void setIdConsumo(int idConsumo) {
        this.idConsumo = idConsumo;
    }
    
    @XmlElement
    public UsuarioJogosResponse getUsuario() {
        return usuario;
    }
    
    public void setUsuario(UsuarioJogosResponse usuario) {
        this.usuario = usuario;
    }
} 