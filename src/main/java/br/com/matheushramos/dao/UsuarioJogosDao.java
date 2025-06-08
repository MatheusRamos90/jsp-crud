package br.com.matheushramos.dao;

import br.com.matheushramos.model.UsuarioJogo;
import br.com.matheushramos.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UsuarioJogosDao {
    
    public void persistirJogos(List<UsuarioJogo> jogos) throws SQLException {
        String sql = "INSERT INTO usuario_jogos (id_usuario, id_jogo, nome_jogo) " +
                    "VALUES (?, ?, ?) " +
                    "ON CONFLICT (id_usuario, id_jogo, nome_jogo) DO NOTHING";
                    
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            for (UsuarioJogo jogo : jogos) {
                stmt.setInt(1, jogo.getIdUsuario());
                stmt.setInt(2, jogo.getIdJogo());
                stmt.setString(3, jogo.getNomeJogo());
                stmt.executeUpdate();
            }
        }
    }
} 