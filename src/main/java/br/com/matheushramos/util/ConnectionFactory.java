package br.com.matheushramos.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost:5432/jsp-studies";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static Connection conexao;
    
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Erro ao carregar o driver do PostgreSQL", e);
        }
    }
    
    public static Connection getConnection() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return conexao;
    }
} 