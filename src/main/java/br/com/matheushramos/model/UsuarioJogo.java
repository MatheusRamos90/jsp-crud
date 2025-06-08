package br.com.matheushramos.model;

public class UsuarioJogo {
    private int idUsuario;
    private int idJogo;
    private String nomeJogo;
    
    public UsuarioJogo() {}
    
    public UsuarioJogo(int idUsuario, int idJogo, String nomeJogo) {
        this.idUsuario = idUsuario;
        this.idJogo = idJogo;
        this.nomeJogo = nomeJogo;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public int getIdJogo() {
        return idJogo;
    }
    
    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }
    
    public String getNomeJogo() {
        return nomeJogo;
    }
    
    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }
}